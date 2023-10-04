package com.boot.SpringBootMaria.v3.dao;

import com.boot.SpringBootMaria.v3.dto.MemberV3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDaoV3 {

    // 전체 리스트
    List<MemberV3> doList();

    // 검색 조회
    List<MemberV3> doSearch(@Param("startDate") String startDate,
                            @Param("endDate") String endDate,
                            @Param("name") String name);
}
