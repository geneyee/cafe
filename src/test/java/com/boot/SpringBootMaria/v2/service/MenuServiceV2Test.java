package com.boot.SpringBootMaria.v2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuServiceV2Test {

    @Autowired
    MenuServiceV2 menuServiceV2;

    @Test
    void doUpdateInsert() {
        List<String> chkList = new ArrayList<>();
        chkList.add("1");
        chkList.add("2");
        String price = "4500";

        menuServiceV2.doUpdateInsert(chkList, price);

    }
}