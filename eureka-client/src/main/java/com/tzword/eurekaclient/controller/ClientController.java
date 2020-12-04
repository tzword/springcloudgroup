package com.tzword.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianghy
 * @Description: 客户端调用
 * @date 2020/12/4 10:54
 */
@RestController
@RequestMapping("/feign")
@Slf4j
public class ClientController {
    @RequestMapping("/hello")
    public void hello(){
        log.info("测试客户端");
    }
}
