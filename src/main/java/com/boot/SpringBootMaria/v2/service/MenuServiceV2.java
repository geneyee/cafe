package com.boot.SpringBootMaria.v2.service;

import com.boot.SpringBootMaria.v2.dao.MenuDaoV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceV2 {

    private MenuDaoV2 menuDaoV2;

    public MenuServiceV2(MenuDaoV2 menuDaoV2){
        this.menuDaoV2 = menuDaoV2;
    }

    // 전체 메뉴 조회
    public List<Coffee_menu> doList() {
        List<Coffee_menu> list = menuDaoV2.doList();

        return list;
    }

    // 검색 - 조회
    public List<Coffee_menu> doSearch(String startDate, String endDate, String coffee, String kind) {
        List<Coffee_menu> list = menuDaoV2.doSearch(startDate, endDate, coffee, kind);
        return list;
    }

    // 검색 - 등록
    public void doInsert(Coffee_menu coffee_menu) {
        menuDaoV2.doInsert(coffee_menu);
    }

    // 검색 - 가격 수정
    public void doUpdatePrice(String no, String price) {
        menuDaoV2.doUpdatePrice(no, price);
    }

    // 검색 - 가격 수정(다중체크)
    public void doUpdatePriceOne(List<String> chkList, String price) {
        menuDaoV2.doUpdatePriceOne(chkList, price);
    }
    // 검색 - 가격 수정(다중체크) - 로그 등록
    public void doInsertLogOne(List<String> chkList, String price) {
        menuDaoV2.doInsertLogOne(chkList, price);
    }

    // 커피 메뉴 수정을 위한 조회
    public Coffee_menu doUpList(String no) {
        Coffee_menu coffee_menu = menuDaoV2.doUpList(no);

        return coffee_menu;
    }

    // 커피 메뉴 수정
    public void doUpdate(Coffee_menu coffee_menu) {
        menuDaoV2.doUpdate(coffee_menu);
    }

    // 커피 삭제
    public void doDelete(String no) {
        menuDaoV2.doDelete(no);
    }

}
