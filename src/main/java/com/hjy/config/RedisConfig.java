package com.hjy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * Created with IntelliJ IDEA.
 * User: Haojunyu
 * Date: 2021/3/31
 * Time: 20:54
 * Description: redis配置类
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(LettuceConnectionFactory RedisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //string类型key序列器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //string类型value序列器
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //hash类型key序列器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash类型value序列器
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        //设置连接方式
        redisTemplate.setConnectionFactory(RedisConnectionFactory);
        return redisTemplate;
    }

}