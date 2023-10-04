package com.boot.SpringBootMaria.v3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v3")
@Controller
public class HomeControllerV3 {

    @GetMapping("/home")
    public String doHome(){
        return "/v3/home/home";
    }
}
