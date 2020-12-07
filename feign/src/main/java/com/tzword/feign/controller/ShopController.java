package com.tzword.feign.controller;

import com.tzword.feign.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jianghy
 * @Description: 商品信息
 * @date 2020/12/7 14:13
 */
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/getShopInfo")
    public String getShopInfo(@RequestParam String name){
        return shopService.testFeignClient(name);
    }
}
