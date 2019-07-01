package org.macos.java.controller;

import org.macos.java.dao.CustomerRepository;
import org.macos.java.model.Customer;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * http://localhost:8080/abc/save
 * http://localhost:8080/abc/find?id=3
 * http://localhost:8080/abc/findall
 *
 *
 * https://grokonez.com/spring-framework/spring-data/spring-data-redis-example-spring-boot-redis-example
 */
@RestController
public class RedisController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        customerRepository.save(new Customer(1, "Jack", "Smith"));
        customerRepository.save(new Customer(2, "Adam", "Johnson"));
        customerRepository.save(new Customer(3, "Kim", "Smith"));
        customerRepository.save(new Customer(4, "David", "Williams"));
        customerRepository.save(new Customer(5, "Peter", "Davis"));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";
        Map<Long, Customer> customers = customerRepository.findAll();

        for (Customer customer : customers.values()) {
            result += customer.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/find")
    public String findById(@RequestParam("id") Long id) {
        String result = "";
        result = customerRepository.find(id).toString();
        return result;
    }

    @RequestMapping(value = "/uppercase")
    public String postCustomer(@RequestParam("id") Long id) {
        Customer customer = customerRepository.find(id);
        customer.setFirstName(customer.getFirstName().toUpperCase());
        customer.setLastName(customer.getLastName().toUpperCase());

        customerRepository.update(customer);

        return "Done";
    }

    @RequestMapping("/delete")
    public String deleteById(@RequestParam("id") Long id) {
        customerRepository.delete(id);

        return "Done";
    }
}

