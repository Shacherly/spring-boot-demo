package org.lion.controller;

import org.lion.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", "影魔");

        Map<String, String> hero = new HashMap<>(128);
        hero.put("h1", "Sf");
        hero.put("h2", "Pa");
        model.addAttribute("hero", hero);

        User user = new User("影魔", "夜魇");
        model.addAttribute("sf", user);
        model.addAttribute("pa", new User("", ""));

        return "/thymeleaf/index";
    }

    @GetMapping("/get")
    public String get(Model model) {
        Map<String, String> hero = new HashMap<>(128);
        hero.put("h1", "Sf???????????????？");
        hero.put("h2", "Pa????????????????");
        model.addAttribute("hero", hero);

        return "/thymeleaf/index::table_refresh";
    }

}
