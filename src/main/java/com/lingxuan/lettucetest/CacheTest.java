package com.lingxuan.lettucetest;

import com.lingxuan.lettucetest.domain.UrgeSettingsDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CacheTest {

    @Cacheable(cacheNames = "cache:settings", key = "#appId + '_' + #sendType")
    public List<UrgeSettingsDto> selectUrgeSettingsList(Long appId, Integer sendType) {
       return null;
    }

    @Cacheable(cacheNames = "cache:settings", key = "#appId + '_' + #sendType + @bean1.sss(#ext)")
    public List<UrgeSettingsDto> selectUrgeSettingsList1(Long appId, Integer sendType,String ext) {
        UrgeSettingsDto settingsDto = new UrgeSettingsDto();
        settingsDto.setAppId(1L);
        return Collections.singletonList(settingsDto);
    }
}
