package org.lion.controller;

import org.lion.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/null")
public class ObjectController {

    @GetMapping("/object")
    public String testNull(Model model) {

        String nullStr = "";
        // String nullStr = "现在有值了";
        User nullUser = null;

        model.addAttribute("nullObj", nullStr);
        model.addAttribute("blankObj", "");
        model.addAttribute("emptyList", Arrays.asList(1, 2, 3, 4));

        Map<String, String> map = new HashMap<>(64);
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        model.addAttribute("map", map);
        model.addAttribute("emptyMap", Collections.emptyMap());

        return "/thymeleaf/null";
    }

}
