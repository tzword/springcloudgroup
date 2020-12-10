package com.tzword.configclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianghy
 * @Description: config类
 * @date 2020/12/9 16:51
 */
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/configTest")
public class ConfigController {

    @Value("${foo}")
    String foo;

    /**
     * @Description: 首先在配置类加注解@RefreshScope（不是启动类）
     * 另外springboot 2.0之后除了暴露了health和info端点外，其他端点均不能访问 可以在配置文件中添加以下配置来解决： management: endpoints: web: exposure: include: "*"(这里也可以是["bus-refresh"])
     * 另外，配置后POST请求更改为：http://ip:port/actuator/bus-refresh
     * @param  1
     * @return java.lang.String
     * @throws
     * @author jianghy
     * @date 2020/12/10 14:04
     */
    @RequestMapping("/getConfigInfo")
    public String getConfigInfo(){
        log.info("获取到配置");
        return foo;
    }
}
