package com.tzword.feign.service.impl;

import com.tzword.feign.service.ShopService;
import org.springframework.stereotype.Component;

/**
 * @author jianghy
 * @Description: 断路器
 * @date 2020/12/8 9:55
 */
@Component
public class ShopServiceHystric implements ShopService {
    @Override
    public String testFeignClient(String name) {
        return "oh! feign error";
    }
}
