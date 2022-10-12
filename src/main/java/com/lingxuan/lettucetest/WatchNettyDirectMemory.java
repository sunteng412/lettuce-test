package com.lingxuan.lettucetest;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;
import org.springframework.util.StringUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 监听堆外
 *
 * @author : longchuan
 * @version :
 * @date : 2022/3/11 3:59 下午
 * @description:
 */
public class WatchNettyDirectMemory {

    static File file = new File("/Users/admin/ideaProject/test/lettuce-test/jvm/jstack-5.3.2.log");

    static {
        boolean del = FileUtil.del(file);
        System.out.println(del);
    }

    /**
     * 监听
     *
     * @param
     * @return
     * @description:
     */
    public static void watch(int capacity, AtomicLong directMemory) {
        //if(capacity > 65536 ){
            System.out.println("堆外内存：新增：" + capacity + " bytes,目前大小：" + directMemory.get() + " bytes");
            jstack(capacity,directMemory);
        //}
    }


    public static void jstack(int capacity, AtomicLong directMemory) {
        String commandHandler = VMUtil.jstack("CommandHandler");
        if(!StringUtils.isEmpty(commandHandler)){
            String jstack = VMUtil.jstack("CommandHandler") + String.format("----------新增：%s-------目前：%s----------------------------\n", capacity,directMemory);
            FileUtil.appendUtf8String(jstack,file);
        }
    }

}

