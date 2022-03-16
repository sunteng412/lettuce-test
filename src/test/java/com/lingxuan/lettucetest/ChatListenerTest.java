package com.lingxuan.lettucetest;


import com.google.common.base.Throwables;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import lombok.SneakyThrows;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatListenerTest {

    @BeforeClass
    public static void init() {
        try {
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get("io.netty.util.internal.PlatformDependent");
            //解冻
            cc.defrost();
            CtMethod m = cc.getDeclaredMethod("incrementMemoryCounter");
            m.insertAfter("com.lingxuan.lettucetest.WatchNettyDirectMemory.watch(capacity,DIRECT_MEMORY_COUNTER);");

            cc.writeFile("/Users/admin/ideaProject/test/lettuce-test/classes");
            cc.toClass(ChatListenerTest.class.getClassLoader());
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }

    }

    @Autowired
    private CacheTest cacheTest;


    @SneakyThrows
    @Test
    public void test() {

        System.out.println("开始");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(cacheTest.selectUrgeSettingsList(100003098L, 10).size());
            });
        }

        System.in.read();
    }

    @SneakyThrows
    @Test
    public void testManyLittle() {

        System.out.println("开始");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                System.out.println(cacheTest.selectUrgeSettingsList(100003098L, 10).size());
            });
        }

        System.in.read();
    }


    @SneakyThrows
    @Test
    public void test1() {
        //System.out.println(cacheTest.selectUrgeSettingsList1(1L, 10,"1").size());
        //System.out.println(cacheTest.selectUrgeSettingsList1(1L, 10,null).size());
        System.out.println(cacheTest.selectUrgeSettingsList1(1L, 10,"").size());
    }
}
