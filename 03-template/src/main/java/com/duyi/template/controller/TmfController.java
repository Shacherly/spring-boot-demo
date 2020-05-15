package com.duyi.template.controller;

import com.duyi.template.bean.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class TmfController {

    @RequestMapping("/tmf")
    public String index(Model model) {
        model.addAttribute("name", "<h1>Thyemleaf</h1>");
        Hero hero = new Hero("蓝猫", "天辉", "紫苑");
        hero.setCamp(null);
        model.addAttribute("hero", hero);
        return "/thymeleaf/index";
    }

    // @RequestMapping("/welcome")
    // public String welcome(Model model) {
    //     model.addAttribute("name", "<h1>Thyemleaf</h1>");
    //     Hero hero = new Hero("蓝猫", "天辉", "紫苑");
    //     // model.addAttribute("hero", hero);
    //     return "/thymeleaf/welcome";
    // }
}
