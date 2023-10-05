package com.boot.SpringBootMaria.v2.service;

import com.boot.SpringBootMaria.comm.BootLog;
import com.boot.SpringBootMaria.comm.MyExceptionRuntime;
import com.boot.SpringBootMaria.v2.dao.MenuDaoV2;
import com.boot.SpringBootMaria.v2.vo.Coffee_menu;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Log4j2
@Service
public class MenuServiceV2 {

    private final MenuDaoV2 menuDaoV2;
    private final BootLog bootLog;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionDefinition definition;

    @Autowired
    TransactionTemplate template;

    public MenuServiceV2(MenuDaoV2 menuDaoV2, BootLog bootLog) {
        this.menuDaoV2 = menuDaoV2;
        this.bootLog = bootLog;
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
    public void doUpdateInsert(List<String> chkList, String price) throws RuntimeException {
        int rI=0;
        int int1=0;
        try {
            log.info("=================== return ===================");
            rI = template.execute(status -> {
                menuDaoV2.doUpdatePriceOne(chkList, price);
//                status.setRollbackOnly();
                return int1;
            });

//            rI = template.execute(status -> {
//                menuDaoV2.doInsertLogOne(chkList, price);
//                return int1;
//            });

            log.info("=================== no return ===================");
            template.equals(new TransactionCallbackWithoutResult() {

                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    menuDaoV2.doInsertLogOne(chkList, price);
//                    status.setRollbackOnly();
                }
            });

        } catch (Exception e) {
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        } finally {
            log.info("================ finally ===============");
            bootLog.doBootLog(getClass().getName());
        }
    }

   /*  #section 12 - 5
    platformTransactionManager 트랜잭션 수동관리
    // 가격 수정 (다중체크) 리팩토링
    public void doUpdateInsert(List<String> chkList, String price) throws RuntimeException {
        try {
            TransactionStatus status = transactionManager.getTransaction(definition);
            menuDaoV2.doUpdatePriceOne(chkList, price);
            transactionManager.commit(status);

            TransactionStatus status2 = transactionManager.getTransaction(definition);
            menuDaoV2.doInsertLogOne(chkList, price);
            transactionManager.rollback(status2);

        } catch (Exception e) {
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        } finally {
            log.info("================ finally ===============");
            bootLog.doBootLog(getClass().getName());
        }
    }
*/

/*  #section 12 - 1, 2, 3, 4
    @Transactional Exception 처리 & propagation(class 분리)

    // 가격 수정 (다중체크) 리팩토링
    @Transactional(propagation = Propagation.REQUIRED) //(rollbackFor = Exception.class)
    public void doUpdateInsert(List<String> chkList, String price) throws RuntimeException {
        log.info("============= price multi update, log insert ===============");

        try {
            menuDaoV2.doUpdatePriceOne(chkList, price);
            menuDaoV2.doInsertLogOne(chkList, price);

            // Checked Exception 발생 지점
//        File file = new File("not_existing_file.txt");
//        FileInputStream stream = new FileInputStream(file);

            // Unchecked Exception 발생 지점 (ArithmeticException - RuntimeException)
            int numerator = 1;
            int denominator = 0;
            int result = numerator / denominator;
        } catch (Exception e) {
            //throw new RuntimeException(e.getMessage());
            throw new MyExceptionRuntime(e.getMessage(), getClass().getName());
        } finally {
            log.info("================ finally ===============");
            bootLog.doBootLog(getClass().getName());
        }
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void doBootLog(String strClass){
//        menuDaoV2.doBootLog(strClass);
//    }
 */

}
