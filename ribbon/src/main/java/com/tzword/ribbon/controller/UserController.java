package com.tzword.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jianghy
 * @Description: 用户管理
 * @date 2020/12/7 11:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getUserInfo")
    @LoadBalanced
    public String getUserInfo(@RequestParam String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi/hello?name=" + name,String.class);
    }

}
