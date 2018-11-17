package com.xicheng.chapter03.framework.common;

import com.xicheng.chapter02.util.CollectionUtil;
import com.xicheng.chapter02.util.StringUtil;
import com.xicheng.chapter03.framework.bean.Data;
import com.xicheng.chapter03.framework.bean.Handler;
import com.xicheng.chapter03.framework.bean.Param;
import com.xicheng.chapter03.framework.bean.View;
import com.xicheng.chapter03.framework.helper.BeanHelper;
import com.xicheng.chapter03.framework.helper.ConfigHelper;
import com.xicheng.chapter03.framework.helper.ControllerHelper;
import com.xicheng.chapter03.framework.util.CodeUtil;
import com.xicheng.chapter03.framework.util.JsonUtil;
import com.xicheng.chapter03.framework.util.ReflectionUtil;
import com.xicheng.chapter03.framework.util.StreamUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 初始化相关Helper类
        HelperLoader.init();
        // 获取ServletContext对象（用于注册Servlet）
        ServletContext servletContext = servletConfig.getServletContext();
        // 注册处理jsp的Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        // 注册处理静态资源的默认Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方法与请求路径
        String requestMethod = req.getMethod().toLowerCase();
        String requestPath = req.getPathInfo();
        // 获取Action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if (handler != null) {
            // 获取Controller类及其Bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            // 创建请求参数对象
            Map<String, Object> paramMap = new HashMap<>();
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
                String body = CodeUtil.decodeURL(StreamUtil.getString(req.getInputStream()));
                if (StringUtil.isNotEmpty(body)) {
                    String[] params = StringUtils.split(body, "&");
                    if (ArrayUtils.isNotEmpty(params)){
                        for (String param : params) {
                            String[] paramBody = StringUtils.split(param, "=");
                            String reqKey = paramBody[0];
                            String reqValue = paramBody[1];
                            paramMap.put(reqKey, reqValue);
                        }
                    }
                }
            }
            Param param = new Param(paramMap);
            // 调用Action方法
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            // 处理Action方法的返回值
            if (result instanceof View) {
                // 返回jsp页面
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                    }else {
                        Map<String, Object> model = view.getModel();
                        for (Map.Entry<String, Object> entry : model.entrySet()) {
                            req.setAttribute(entry.getKey(), entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
                    }
                }
            } else if (result instanceof Data) {
                // 返回json数据
                Data data = (Data) result;
                Object model = data.getData();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter printWriter = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    printWriter.write(json);
                    printWriter.flush();
                    printWriter.close();
                }
            }
        }
    }
}
