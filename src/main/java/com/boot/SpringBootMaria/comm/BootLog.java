package com.boot.SpringBootMaria.comm;

import com.boot.SpringBootMaria.v2.dao.MenuDaoV2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BootLog {

    private final MenuDaoV2 menuDaoV2;

    public BootLog(MenuDaoV2 menuDaoV2) {
        this.menuDaoV2 = menuDaoV2;
    }

    public void doBootLog(String strClass){
        menuDaoV2.doBootLog(strClass);
    }
}
