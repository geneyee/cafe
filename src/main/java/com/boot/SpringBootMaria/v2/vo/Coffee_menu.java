package com.boot.SpringBootMaria.v2.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Coffee_menu {
    private String no;
    private String coffee;
    private String kind;
    private String price;
    private String reg_day;
    private String mod_day;

    public Coffee_menu() {

    }

}
