package com.goodsoft.hotel.controller;

import com.goodsoft.hotel.domain.entity.Test;
import com.goodsoft.hotel.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 * ===>测试
 *
 * @author 严彬荣 Created on 2017-11-07 16:27
 */
@RestController
public class TestController {
    @Resource
    private TestService service;

    @RequestMapping("/test")
    public List<Test> test(String name) {
        try {
            return this.service.queryTestService();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
