package com.boot.SpringBootMaria.v1.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuDaoTest {

    @Autowired
    MenuDao menuDao;

    @Test
    void doList() {
        List<Map<String, Object>> list = menuDao.doList();
        //log.info(list);
        System.out.println("==================");
        System.out.println(list);
        System.out.println("==================");
    }

    @Test
    void insertMenu() {
        menuDao.insertMenu("테스트", "커피", "5000");
    }
}