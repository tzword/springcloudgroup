package com.tzword.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jianghy
 * @Description: 商户服务
 * @date 2020/12/7 14:22
 */

@FeignClient(value = "service-hi")
public interface ShopService {
    @GetMapping("/hi/hello")
    String testFeignClient(@RequestParam String name);
}
