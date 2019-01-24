package com.minstone.pepsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Describe 类描述，功能介绍
 * @Author chenlu
 * @Version V1.0
 * @Date 2019/1/24.
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(String name){
        if(name!=null){
            System.out.println(name);

        }
        return "hello.jsp";
    }
}
