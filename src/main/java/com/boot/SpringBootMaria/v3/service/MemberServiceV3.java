package com.boot.SpringBootMaria.v3.service;

import com.boot.SpringBootMaria.v3.dao.MemberDaoV3;
import com.boot.SpringBootMaria.v3.dto.MemberV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceV3 {

    private final MemberDaoV3 memberDaoV3;

    //전체 리스트
    public List<MemberV3> doList() {
        List<MemberV3> list = memberDaoV3.doList();

        return list;
    }

    // 검색 조회
    public List<MemberV3> doSearch(String startDate, String endDate, String name) {
        List<MemberV3> list = memberDaoV3.doSearch(startDate, endDate, name);
        return list;
    }
}
