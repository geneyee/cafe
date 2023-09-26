package com.boot.SpringBootMaria.v2.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Member {

    private String no;
    private String cust_id;
    private String name;
    private String email;
    private String role;
    private String reg_day;
}
