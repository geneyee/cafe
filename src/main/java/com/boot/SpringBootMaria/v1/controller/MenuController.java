package com.boot.SpringBootMaria.v1.controller;

import com.boot.SpringBootMaria.v1.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1")
public class MenuController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/menu")
    public String doMenu(Model model) {
        // Data 만들기, List, Map
        List<Map<String, Object>> list = menuService.doList();

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "========= MenuController =========");

        return "/v1/menu/menu";
    }

    // 메뉴 등록 화면
    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v1/menu/menu_ins";
    }

    // 메뉴 등록
    @PostMapping("/menu_ins")
    public String doInsertPost(@RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice) {

        menuService.insertMenu(strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }
}
