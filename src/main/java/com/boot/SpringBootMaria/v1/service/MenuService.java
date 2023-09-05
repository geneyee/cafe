package com.boot.SpringBootMaria.v1.service;

import com.boot.SpringBootMaria.v1.dao.MenuDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public MenuService() {
//        log.info("============ MenuService, 생성자 ============");
    }

    // 메뉴 조회
    public List<Map<String, Object>> doList() {

        List<Map<String, Object>> list = menuDao.doList();

        log.info(list);

        return list;
    }

    public List<Map<String, Object>> doListOld() {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "아이스커피");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2023-08-18");
        map.put("mod_day", "2023-08-18");
        list.add(map);

        Map<String, Object> map2 = new HashMap<>();

        map2.put("No", "2");
        map2.put("name", "카푸치노");
        map2.put("kind", "커피");
        map2.put("price", "6,000");
        map2.put("reg_day", "2023-08-18");
        map2.put("mod_day", "2023-08-18");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();

        map3.put("No", "3");
        map3.put("name", "카페라떼");
        map3.put("kind", "커피");
        map3.put("price", "6,500");
        map3.put("reg_day", "2023-08-18");
        map3.put("mod_day", "2023-08-18");
        list.add(map3);

//        log.info(list);

        return list;
    }

    // 메뉴 등록
    public void insertMenu(String strCoffee, String strKind, String strPrice) {
        menuDao.insertMenu(strCoffee, strKind, strPrice);
    }

    // 메뉴 삭제
    public void deleteMenu(String strNo) {
        menuDao.deleteMenu(strNo);
    }
}
