package com.lingxuan.lettucetest;

import com.lingxuan.lettucetest.domain.UrgeSettingsDto;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class CacheTest {

    @Cacheable(cacheNames = "cache:settings", key = "#appId + '_' + #sendType")
    public List<UrgeSettingsDto> selectUrgeSettingsList(Long appId, Integer sendType) {
       return null;
    }

}
