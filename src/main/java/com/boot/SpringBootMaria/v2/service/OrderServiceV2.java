package com.boot.SpringBootMaria.v2.service;

import com.boot.SpringBootMaria.v2.dao.OrderDaoV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceV2 {

    private OrderDaoV2 orderDaoV2;

    public OrderServiceV2(OrderDaoV2 orderDaoV2) {
        this.orderDaoV2 = orderDaoV2;
    }

    // 전체 조회
    public List<Coffee_Order> doList() {
        List<Coffee_Order> list = orderDaoV2.doList();

        return list;
    }

    // 검색 - 조회
    public List<Coffee_Order> doSearch(String startDate, String endDate, String coffee, String name) {
        List<Coffee_Order> list = orderDaoV2.doSearch(startDate, endDate, coffee, name);
        return list;
    }


}
