package com.lingxuan.lettucetest.config;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class CacheTestConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    private RedisConnectionFactory buildConnectionFactory(RedisConnectionFactory redisConnectionFactory, int database){
        if(redisConnectionFactory instanceof JedisConnectionFactory){
            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
            BeanUtils.copyProperties(redisConnectionFactory,jedisConnectionFactory);
            jedisConnectionFactory.getStandaloneConfiguration().setDatabase(database);
            jedisConnectionFactory.afterPropertiesSet();
            return jedisConnectionFactory;
        }else {
            LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
            BeanUtils.copyProperties(redisConnectionFactory,lettuceConnectionFactory);
            lettuceConnectionFactory.getStandaloneConfiguration().setDatabase(database);
            lettuceConnectionFactory.afterPropertiesSet();
            return lettuceConnectionFactory;
        }
    }

    @Bean
    public RedisCacheManager redisCacheManager() {
        RedisConnectionFactory connectionFactory = buildConnectionFactory(redisConnectionFactory, 0);
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);

        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // 支持反序列化 LocalDate
        om.registerModule(new JavaTimeModule());
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(om);

        RedisSerializationContext.SerializationPair<Object> value = RedisSerializationContext.SerializationPair.fromSerializer(serializer);

        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration
                .defaultCacheConfig()
                .computePrefixWith(name -> name + ":")  // 默认 name 后面接两个 ::, 仅保留一个
                .serializeValuesWith(value)
                .entryTtl(Duration.ofMinutes(30));   // 缓存失效 30 分钟

        return new RedisCacheManager(redisCacheWriter, cacheConfig);
    }

}
