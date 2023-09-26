package com.boot.SpringBootMaria.v2.controller;

import com.boot.SpringBootMaria.v2.service.OrderServiceV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_Order;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@RequestMapping("/v2")
@Controller
public class OrderControllerV2 {

    private OrderServiceV2 orderServiceV2;

    public OrderControllerV2(OrderServiceV2 orderServiceV2) {
        this.orderServiceV2 = orderServiceV2;
    }

    // 전체 조회
    @GetMapping("/order")
    public String doOrder(Model model){
        List<Coffee_Order> list = orderServiceV2.doList();

        model.addAttribute("list", list);

        return "/v2/order/order";
    }

    // 검색 - 조회
    @PostMapping("order_search")
    public String doSearch(@RequestParam("start_date") String startDate,
                           @RequestParam("end_date") String endDate,
                           @RequestParam String coffee,
                           @RequestParam String name,
                           Model model) {

        List<Coffee_Order> list = orderServiceV2.doSearch(startDate, endDate, coffee, name);
        model.addAttribute("list", list);

        return "/v2/order/order";
    }

}
