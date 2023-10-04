package com.boot.SpringBootMaria.v3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberV3 {

    private String no;
    private String cust_id;
    private String name;
    private String email;
    private String role;
    private String reg_day;

}
