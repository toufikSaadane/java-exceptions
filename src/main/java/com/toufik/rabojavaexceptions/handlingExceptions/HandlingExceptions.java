package com.toufik.rabojavaexceptions.handlingExceptions;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j

public class HandlingExceptions {

    @Test
    public void firstExample(){
        int i = 12;
        int j = 2;
        try {
            int result = i / (j -2);
            log.info("The result is : {} ", result);
        }catch (Exception ex){
            log.info("ERROR :  {}", ex.getMessage() );
            ex.printStackTrace();
        }
        log.info("PROGRAMME DONE");
    }
}
