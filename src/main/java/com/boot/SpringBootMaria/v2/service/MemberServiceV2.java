package com.boot.SpringBootMaria.v2.service;

import com.boot.SpringBootMaria.v2.dao.MemberDaoV2;
import com.boot.SpringBootMaria.v2.vo.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceV2 {

    private MemberDaoV2 memberDaoV2;

    public MemberServiceV2(MemberDaoV2 memberDaoV2) {
        this.memberDaoV2 = memberDaoV2;
    }

    // 전체 조회
    public List<Member> doList() {
        List<Member> list = memberDaoV2.doList();
        return list;
    }

    // 이름 조회
    public List<Member> doSearch(String startDate, String endDate, String name) {
        List<Member> list = memberDaoV2.doSearch(startDate, endDate, name);
        return list;
    }
}
