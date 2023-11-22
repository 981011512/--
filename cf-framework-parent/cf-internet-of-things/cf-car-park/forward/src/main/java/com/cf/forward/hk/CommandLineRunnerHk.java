package com.cf.forward.hk;

import com.cf.forward.hk.hardware.HkHelperInterface;
import com.cf.forward.hk.utils.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandLineRunnerHk implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {


       new Thread(() ->{

           while (true){
               HkHelperInterface hkHelper = SpringContextUtil.getBean(HkHelperInterface.class);
               hkHelper.ledOutFree();
//               log.info("=====");
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();

    }
}
