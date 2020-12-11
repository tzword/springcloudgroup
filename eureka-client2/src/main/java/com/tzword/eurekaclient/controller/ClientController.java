package com.tzword.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianghy
 * @Description: 客户端调用
 * @date 2020/12/4 10:54
 */
@RestController
@RequestMapping("/lucy")
@Slf4j
public class ClientController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(@RequestParam String name){
        log.info("测试客户端");
        return "hi " + name + ",i am form port:" + port;
    }


    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
