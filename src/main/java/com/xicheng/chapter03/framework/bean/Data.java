package com.xicheng.chapter03.framework.bean;

/**
 * 返回数据对象
 */
public class Data {
    // 模型数据
    private Object data;

    public Data() {
    }

    public Data(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
