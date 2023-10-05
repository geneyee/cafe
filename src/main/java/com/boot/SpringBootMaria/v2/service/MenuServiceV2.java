package com.boot.SpringBootMaria.v2.service;

import com.boot.SpringBootMaria.v2.dao.MenuDaoV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Log4j2
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

    // 가격 수정 (다중체크) 리팩토링
    @Transactional(rollbackFor = Exception.class)
    public void doUpdateInsert(List<String> chkList, String price) throws FileNotFoundException {
        log.info("============= price multi update, log insert ===============");

        menuDaoV2.doUpdatePriceOne(chkList, price);

        // Checked Exception 발생 지점
//        File file = new File("not_existing_file.txt");
//        FileInputStream stream = new FileInputStream(file);

        // Unchecked Exception 발생 지점 (ArithmeticException - RuntimeException)
        int numerator = 1;
        int denominator = 0;
        int result = numerator / denominator;

        menuDaoV2.doInsertLogOne(chkList, price);
    }
}
