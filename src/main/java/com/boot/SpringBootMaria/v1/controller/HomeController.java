package com.boot.SpringBootMaria.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class HomeController {

    @GetMapping("/home")
    public String doHome(){
        return "/v1/home/home";
    }

    @GetMapping("/home2")
    public String doHome2Get() {
        System.out.println("Get");
        return "/v1/home/home";
    }

    @PostMapping("/home2")
    public String doHome2Post() {
        System.out.println("Post");
        return "/v1/home/home";
    }

}
