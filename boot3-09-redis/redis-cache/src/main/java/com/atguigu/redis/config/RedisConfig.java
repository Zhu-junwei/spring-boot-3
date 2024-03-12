package com.atguigu.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * 定义Redis的序列化器
 * <p>
 *     Redis的对象序列化使用的是JdkSerializationRedisSerializer，数据在redis格式不方面排查，
 *     此工具类自定义了序列化器。
 * @author 朱俊伟
 * @since 2023/11/02 22:49
 */
@Configuration
@EnableCaching
public class RedisConfig {

    /**
     * redis数据库自定义key
     */
    public  static final String REDIS_KEY_DATABASE="zjw";

    /**
     * 默认过期 1:h
     */
    private static final long REDIS_DEFAULT_TTL = 60 * 24L;

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        //简单的字符串序列化器
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //对象转JSON序列化器
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = jackson2JsonRedisSerializer();
        //String类型 key value
        redisTemplate.setKeySerializer(stringRedisSerializer); // key的序列化类型
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer()); // value的序列化类型
        //Hash类型 key value
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 对象转JSON序列化器
     */
    @Bean
    public Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer(){
        ObjectMapper  objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance ,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        return new Jackson2JsonRedisSerializer<>(objectMapper,Object.class);
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        //设置Redis缓存有效期为1天
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer())).entryTtl(Duration.ofMinutes(REDIS_DEFAULT_TTL));
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }


}