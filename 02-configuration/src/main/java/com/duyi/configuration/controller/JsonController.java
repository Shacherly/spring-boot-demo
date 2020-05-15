package com.duyi.configuration.controller;

import com.duyi.configuration.bean.Hero;
import com.duyi.configuration.bean.Naga;
import com.duyi.configuration.bean.Sf;
import com.duyi.configuration.bean.User;
import com.duyi.configuration.config.HeroConfig;
import com.duyi.configuration.config.NagaConfig;
import com.duyi.configuration.config.SfConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class JsonController {
    // @Value("${sf.name}")
    // private String name;
    // @Value("${sf.camp}")
    // private String camp;
    @Autowired
    private NagaConfig nagaConfig;

    @GetMapping("/naga")
    public Naga getNaga() {
        return new Naga(nagaConfig.getHeroName(), nagaConfig.getCampName(), nagaConfig.getPosition());
    }

    @Autowired
    private SfConfig sfConfig;

    @GetMapping("/sf")
    public Sf getSf() {
        return new Sf(sfConfig.getName(), sfConfig.getCamp());
    }

    //================@ConfigurationProperties(prefix = "base")配置
    @Autowired
    private HeroConfig heroConfig;

    @GetMapping("/hero")
    public Hero getHero(Hero hero) {
        hero.setAttribute(heroConfig.getAttribute());
        hero.setSupport(heroConfig.getSupport());
        hero.setMagic(heroConfig.getMagic());
        hero.setHero(heroConfig.getHero());
        return hero;
    }

    //================加密配置
    @Value("${info.username}")
    private String username;
    @Value("${info.password}")
    private String password;

    @GetMapping("/user")
    public String getUser(User user) {
        return username + "\t" + password;
    }
}
