package com.duyi.template.controller;

import com.duyi.template.bean.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class FtlController {

    @RequestMapping("/ftl")
    public String index(Model model) {
        Hero hero = new Hero("蓝猫", "天辉", "紫苑");
        model.addAttribute("now", new Date().toString());
        model.addAttribute("hero", hero);
        return "/freemarker/index";
    }
}
