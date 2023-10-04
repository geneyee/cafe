package com.boot.SpringBootMaria.v3.controller;

import com.boot.SpringBootMaria.v3.service.MemberServiceV3;
import com.boot.SpringBootMaria.v3.dto.MemberV3;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v3")
@Controller
public class MemberControllerV3 {

    private final MemberServiceV3 memberServiceV3;

/*
    // 주입
    public MemberControllerV3(MemberServiceV3 memberServiceV3) {
        this.memberServiceV3 = memberServiceV3;
    }
*/

    // 전체 조회
    @GetMapping("/member")
    public String doMember(Model model){
        List<MemberV3> list = memberServiceV3.doList();
        model.addAttribute("list", list);

        return "/v3/member/member";
    }

    // 검색 조회
    @GetMapping("/member_search")
    public String doSearch(@RequestParam("start_date") String startDate,
                           @RequestParam("end_date") String endDate,
                           @RequestParam(value = "name", defaultValue = "ALL") String name,
                           Model model) {

        List<MemberV3> list = memberServiceV3.doSearch(startDate, endDate, name);
        model.addAttribute("list", list);

        return "/v3/member/member";
    }

}
