package com.lingxuan.lettucetest;

import ch.qos.logback.core.OutputStreamAppender;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.google.common.base.Throwables;
import io.netty.util.internal.StringUtil;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;

/**
 * 推荐
 * @author     : longchuan
 * @date       : 2022/3/11 3:52 下午
 * @description:
 * @version    :
 */
public class VMUtil {



    @SneakyThrows
    public static String jstack(String keyword) {
        return jstack(Thread.getAllStackTraces(),keyword);
    }

    public static String jstack(Map<Thread, StackTraceElement[]> map,String keyword) {
        StringBuilder result = new StringBuilder();
        try {
            Iterator<Map.Entry<Thread, StackTraceElement[]>> ite = map.entrySet().iterator();
            while (ite.hasNext()) {
                Map.Entry<Thread, StackTraceElement[]> entry = ite.next();
                StackTraceElement[] elements = entry.getValue();
                Thread thread = entry.getKey();
                if (elements != null && elements.length > 0) {
                    String threadName = entry.getKey().getName();
                    StringBuilder tmp = new StringBuilder(
                            String.format("%-40sTID: %d STATE: %s%n", threadName, thread.getId(), thread.getState()));
                    boolean keywordCondition = Boolean.FALSE;
                    for (StackTraceElement el : elements) {
                        String elStr = el.toString();
                        if(StringUtil.isNullOrEmpty(keyword)){
                            tmp.append(String.format("%-40s%s%n", threadName, elStr));
                            keywordCondition = Boolean.TRUE;
                        }else if(elStr.contains(keyword)){
                            tmp.append(String.format("%-40s%s%n", threadName, elStr));
                            keywordCondition = Boolean.TRUE;
                        }
                    }
                    if(keywordCondition){
                        result.append(tmp).append("\n");
                    }
                }
            }
        } catch (Throwable e) {
            result.append(ExceptionUtil.exceptionSimpleDesc(e));
        }

        return result.toString();
    }



}
