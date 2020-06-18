package com.cf.chat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MessageTest.class)
@RunWith(SpringRunner.class)
public class MessageTest {

    @Test
    public void test1(){
        System.out.println("11111");
    }

}
