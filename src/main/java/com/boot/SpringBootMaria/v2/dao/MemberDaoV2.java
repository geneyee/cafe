package com.boot.SpringBootMaria.v2.dao;

import com.boot.SpringBootMaria.v2.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberDaoV2 {
    // 전체 조회
    List<Member> doList();
    // 이름 조회
    List<Member> doSearch(@Param("startDate") String startDate,
                          @Param("endDate") String endDate,
                          @Param("name") String name);
}
