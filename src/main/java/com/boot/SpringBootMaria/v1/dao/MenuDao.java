package com.boot.SpringBootMaria.v1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuDao {

    // 조회
    List<Map<String, Object>> doList();

    // 메뉴등록
    void insertMenu(@Param("strCoffee") String strCoffee,
                   @Param("strKind") String strKind,
                   @Param("strPrice") String strPrice);

    // 메뉴 삭제
    void deleteMenu(@Param("strNo") String strNo);

    // 조회(수정)
    Map<String, Object> doUpList(String strNo);

    // 수정
    void updateMenu(@Param("strNo") String strNo,
                    @Param("strCoffee") String strCoffee,
                    @Param("strKind") String strKind,
                    @Param("strPrice") String strPrice);
}
