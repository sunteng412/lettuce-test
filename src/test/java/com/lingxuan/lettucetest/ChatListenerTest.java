package com.lingxuan.lettucetest;


import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatListenerTest {

    @Autowired
    private CacheTest cacheTest;


    @SneakyThrows
    @Test
    public void test() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 4; i++) {

            executorService.execute(()->{
                System.out.println(cacheTest.selectUrgeSettingsList(100003098L,10).size());;
            });
        }

        TimeUnit.SECONDS.sleep(10);

        for (int i = 0; i < 4; i++) {

            executorService.execute(()->{
                System.out.println(cacheTest.selectUrgeSettingsList(100003098L,10).size());;
            });
        }

        System.in.read();
    }
}
