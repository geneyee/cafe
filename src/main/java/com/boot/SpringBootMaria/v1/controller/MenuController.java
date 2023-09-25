package com.boot.SpringBootMaria.v1.controller;

import com.boot.SpringBootMaria.v1.service.MenuService;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
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

    // 메뉴 삭제
    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") String strNo) {

        log.info(" ================== strNo : " + strNo + "==================");

        menuService.deleteMenu(strNo);

        return "redirect:/v1/menu";
    }

    // 메뉴 수정
    @GetMapping("/menu_up")
    public String doUpdate(@RequestParam("no") String strNo, Model model) {

        Map<String, Object> map = menuService.doUpList(strNo);
        model.addAttribute("map", map);
        return "/v1/menu/menu_up";
    }

    // 메뉴 수정
    @PostMapping("/menu_up")
    public String doUpdatePost(@RequestParam("no") String strNo,
                               @RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice) {

        menuService.updateMenu(strNo, strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    // 조회하기
    @PostMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                           @RequestParam("kind") String strKind,
                           Model model) {

        log.info("strStartDate :"+strStartDate);
        List<Map<String, Object>> list = menuService.doSearch(strStartDate,strEndDate, strCoffee,strKind );
        model.addAttribute("list", list);

        return "/v1/menu/menu";
    }

    // 가격수정 - 다중체크
    @PostMapping("/menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                                @RequestParam("hidden_price") String strPrice){

        if (chkList != null) {
            for (String strNo : chkList) {
                int num1 = menuService.doUdatePrice(strNo, strPrice);
                int num2 = menuService.doInsertLog(strNo, strPrice);
            }
        }
        return "redirect:/v1/menu";
    }

}
