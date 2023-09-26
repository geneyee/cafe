package com.boot.SpringBootMaria.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v2")
public class HomeControllerV2 {

    @GetMapping("/home")
    private String doHome(){
        return "/v2/home/home";
    }

}
