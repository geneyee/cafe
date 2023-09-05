package com.boot.SpringBootMaria.v1.controller;

import com.boot.SpringBootMaria.v1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/v1/menu")
    public String doMenu(Model model){
        // Data 만들기, List, Map
        List<Map<String, Object>> list = menuService.doList();

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "========= MenuController =========");

        return "/v1/menu/menu";
    }
}
