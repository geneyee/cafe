package com.boot.SpringBootMaria.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
    @GetMapping("v1/rest")
    public String doRest(){
        String strHtml = "<html><body>Hello!</body></html>";
        return  strHtml;
    }
}
