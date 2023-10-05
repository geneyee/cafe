package com.boot.SpringBootMaria.v2.controller;

import com.boot.SpringBootMaria.v2.service.MenuServiceV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequestMapping("/v2")
@Controller
public class MenuControllerV2 {

    private MenuServiceV2 menuServiceV2;
    private Coffee_menu coffee_menu;

    public MenuControllerV2(MenuServiceV2 menuServiceV2) {
        this.menuServiceV2 = menuServiceV2;
    }

    // 전체 메뉴 조회
    @RequestMapping("/menu")
    public String doMenu(Model model) {
        List<Coffee_menu> list = menuServiceV2.doList();
        model.addAttribute("list", list);

        return "/v2/menu/menu";
    }

    // 검색 - 조회
    @PostMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String startDate,
                           @RequestParam("end_date") String endDate,
                           @RequestParam String coffee,
                           @RequestParam String kind,
                           Model model) {

        List<Coffee_menu> list = menuServiceV2.doSearch(startDate, endDate, coffee, kind);
        model.addAttribute("list", list);

        return "/v2/menu/menu";
    }

    // 검색 - 등록
    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v2/menu/menu_ins";
    }

    // 검색 - 등록
    @PostMapping("/menu_ins")
    public String doInsertPost(@ModelAttribute Coffee_menu coffee_menu) {
        menuServiceV2.doInsert(coffee_menu);

        return "redirect:/v2/menu";
    }

/*    // 검색 - 가격 수정
    @PostMapping("menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkCoffeeNo") String no,
                                @RequestParam("hidden_price") String price) {

        menuServiceV2.doUpdatePrice(no, price);

        return "redirect:/v2/menu";
    }*/

    // 검색 - 가격 수정
    @PostMapping("/menu_updatePrice")
    public String doUpdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                                @RequestParam("hidden_price") String price,
                                Model model) {

        String ex_return = "redirect:/v2/menu";

        try {
            if (chkList != null) {
                menuServiceV2.doUpdateInsert(chkList, price);
//            menuServiceV2.doUpdatePriceOne(chkList, price);
//            menuServiceV2.doInsertLogOne(chkList, price);
            }
        } catch (Exception e) {
            log.info("======================== Error : " + e.getMessage());
            model.addAttribute("em", e.getMessage());
            ex_return = "/v2/comm/ErrorPage";
        }
        return ex_return;
    }

    // 커피 메뉴 수정
    @GetMapping("/menu_up")
    public String doUpdateGet(@RequestParam String no, Model model) {
        coffee_menu = menuServiceV2.doUpList(no);
        model.addAttribute("vo", coffee_menu);

        return "/v2/menu/menu_up";
    }

    // 커피 메뉴 수정
    @PostMapping("/menu_up")
    public String doUpdate(Coffee_menu coffee_menu) {

        menuServiceV2.doUpdate(coffee_menu);

        return "redirect:/v2/menu";
    }

    // 삭제
    @GetMapping("/menu_del")
    public String doDelete(@RequestParam String no) {
        menuServiceV2.doDelete(no);
        return "redirect:/v2/menu";
    }
}
