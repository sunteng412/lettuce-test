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
import java.util.concurrent.TimeUnit;


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
            //m.insertBefore("{ System.out.println(\"incrementMemoryCounter start!!!\"); }");
            //m.insertAfter("{System.out.println(\"堆外内存：新增：\" +capacity + \" bytes,目前大小：\" + DIRECT_MEMORY_COUNTER.get() + \" bytes\"); }");
            m.insertAfter("com.lingxuan.lettucetest.WatchNettyDirectMemory.watch(capacity,DIRECT_MEMORY_COUNTER);");

            //m.insertAfter("{ System.out.println(\"incrementMemoryCounter end!!!\"); }");
            cc.writeFile("/Users/admin/ideaProject/test/lettuce-test/classes");
            //cc.writeFile();
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

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                System.out.println(cacheTest.selectUrgeSettingsList(100003098L, 10).size());
            });
        }

//        for (int i = 0; i < 4; i++) {
//            executorService.execute(() -> {
//                System.out.println(cacheTest.selectUrgeSettingsList(100003098L, 10).size());
//            });
//        }
        System.in.read();
    }
}
