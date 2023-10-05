package com.boot.SpringBootMaria.v2.vo;

import lombok.Data;


@Data
public class Coffee_Order {

    private String no;
    private String coffee_no;
    private String coffee;
    private String price;
    private String cust_id;
    private String name;
    private String reg_day;

    public Coffee_Order(){}
}
