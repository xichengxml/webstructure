package com.xicheng.chapter2.test;

import com.xicheng.chapter02.pojo.Customer;
import com.xicheng.chapter02.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceTest {

    private final CustomerService customerService = new CustomerService();

    @Before
    public void init() {

    }

    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() {
        Customer customer = customerService.getCustomer(1);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer3");
        fieldMap.put("contact", "Emily");
        fieldMap.put("telephone", "13813813813");
        boolean result = customerService.CreateCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() {
        long id = 3;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Kelly");
        boolean result = customerService.updateCustomer(id, fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() {
        long id = 3;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
