package com.boot.SpringBootMaria.v2.dao;

import com.boot.SpringBootMaria.v2.vo.Coffee_Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDaoV2 {

    // 전체 조회
    List<Coffee_Order> doList();

    // 검색 조회
    List<Coffee_Order> doSearch(@Param("startDate") String startDate,
                                @Param("endDate") String endDate,
                                @Param("coffee") String coffee,
                                @Param("name") String name);

}
