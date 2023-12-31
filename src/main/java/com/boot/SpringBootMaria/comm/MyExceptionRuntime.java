package com.boot.SpringBootMaria.comm;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyExceptionRuntime extends RuntimeException {

    public MyExceptionRuntime(String s) {
        super("My Exception 처리 => " + s);
    }

    public MyExceptionRuntime(String s, String sClass) {
        super("My Exception 처리 => [[ " + s + " ]]");
        log.info("MyException Class 에러 발생 => " + sClass);
    }
}
