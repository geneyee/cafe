package com.boot.SpringBootMaria.v2.dao;

import com.boot.SpringBootMaria.v2.vo.Coffee_menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDaoV2 {

    // 전체 조회
    List<Coffee_menu> doList();

    // 검색 - 조회
    List<Coffee_menu> doSearch(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("coffee") String coffee, @Param("kind") String kind);

    // 검색 - 등록
    void doInsert(Coffee_menu coffee_menu);

    // 검색 - 가격 수정
    void doUpdatePrice(@Param("no") String no, @Param("price") String price);

    // 검색 - 가격 수정(다중체크)
    void doUpdatePriceOne(@Param("chkList") List<String> chkList, @Param("price") String price);

    // 검색 - 가격 수정(다중체크) - 로그 등록
    void doInsertLogOne(@Param("chkList") List<String> chkList, @Param("price") String price);

    // 커피 메뉴 수정
    void doUpdate(Coffee_menu coffee_menu);

    // 커피 메뉴 수정을 위한 조회
    Coffee_menu doUpList(@Param("no") String no);

    // 삭제
    void doDelete(@Param("no") String no);

    // 전체 로그
    void doBootLog(String strClass);
}
