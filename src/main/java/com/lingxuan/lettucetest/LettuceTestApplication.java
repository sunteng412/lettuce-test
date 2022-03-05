package com.lingxuan.lettucetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LettuceTestApplication {

    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        SpringApplication.run(LettuceTestApplication.class, args);
    }

}
