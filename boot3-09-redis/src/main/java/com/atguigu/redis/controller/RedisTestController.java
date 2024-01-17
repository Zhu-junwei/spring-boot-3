package com.atguigu.redis.controller;

import com.atguigu.redis.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author 朱俊伟
 * @since 2023/11/02 12:18
 */
@RestController
public class RedisTestController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //为了后来系统的兼容性，应该所有对象都是以json的方式进行保存
    @Autowired //如果给redis中保存数据会使用默认的序列化机制，导致redis中保存的对象不可视
    RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        //常见数据类型  k: v value可以有很多类型
        //string： 普通字符串 ： redisTemplate.opsForValue()
        //list:    列表：       redisTemplate.opsForList()
        //set:     集合:       redisTemplate.opsForSet()
        //zset:    有序集合:    redisTemplate.opsForZSet()
        //hash：   map结构：    redisTemplate.opsForHash()
        Long countPeople = stringRedisTemplate.opsForValue().increment("count-people");
        return "访问了【"+countPeople+"】次";
    }

    @GetMapping("/person/save")
    public String savePerson() throws JsonProcessingException {
        Person person = new Person(1L,"张三",18,new Date());

        //1、序列化： 对象转为字符串方式，通过redisTemplate的序列化机制实现
        redisTemplate.opsForValue().set("person",person);

        return "ok";
    }

    @GetMapping("/person/get")
    public Person getPerson(){
        System.out.println(redisTemplate.opsForValue().get("person"));
        return (Person) redisTemplate.opsForValue().get("person");
    }
}
