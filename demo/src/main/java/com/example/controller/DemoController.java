package com.example.controller;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by root on 19/09/2016.
 */
@RestController
@Transactional
public class DemoController {

    @Autowired
    CustomerDao customerDao;

    @RequestMapping("/save")
    public String process() {
        customerDao.createCustomer(new Customer("Jack", "Smith"));
        customerDao.createCustomer(new Customer("Adam", "Johnson"));
        customerDao.createCustomer(new Customer("Kim", "Smith"));
        customerDao.createCustomer(new Customer("David", "Williams"));
        customerDao.createCustomer(new Customer("Peter", "Davis"));
        return "Done";
    }

    @RequestMapping("/")
    public String hello(){
        return "Hello Hung ";
    }

    @RequestMapping("/findAll")
    public String findAll() {
        List<Customer> list = customerDao.getAllCustomer();
        String result = "<html>";
        for (Customer customer : list) {

            result += " <div>" + customer.toString() + "</div> ";
        }

        return result;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id) {
        String result = "";
        result = customerDao.getCustommerById(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "<html>";

        result = customerDao.getCustomerByLastName(lastName).toString();

        return result + "</html>";
    }
}
