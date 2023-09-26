package com.boot.SpringBootMaria.v2.controller;

import com.boot.SpringBootMaria.v2.service.MemberServiceV2;
import com.boot.SpringBootMaria.v2.vo.Member;
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
public class MemberControllerV2 {

    private MemberServiceV2 memberServiceV2;

    public MemberControllerV2(MemberServiceV2 memberServiceV2) {
        this.memberServiceV2 = memberServiceV2;
    }

    // 전체 조회
    @GetMapping("/member")
    public String doMember(Model model){
        List<Member> list = memberServiceV2.doList();
        model.addAttribute("list", list);

        return "/v2/member/member";
    }

    // 이름 조회
    @PostMapping("/member_search")
    public String doSearch(@RequestParam("start_date") String startDate,
                           @RequestParam("end_date") String endDate,
                           @RequestParam String name,
                           Model model) {
        List<Member> list = memberServiceV2.doSearch(startDate, endDate, name);
        model.addAttribute("list", list);

        return "/v2/member/member";
    }
}
