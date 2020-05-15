package com.duyi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        System.out.println("index controller");
        return "Lmy";
    }
}
