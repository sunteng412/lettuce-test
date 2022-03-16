package com.lingxuan.lettucetest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
public class Bean1 {

    public String sss(Object o){
        if(Objects.nonNull(o)){
            if(o instanceof String && StringUtils.isEmpty(o)){
                return "";
            }
            return "_" + o.toString();
        }
        return "";
    }
}
