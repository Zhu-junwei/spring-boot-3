package com.zjw.redis;

import com.zjw.redis.entity.Person;
import com.zjw.redis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.*;

@SpringBootTest
@Slf4j
class Boot309RedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 测试向redis里放入string,获取值
     */
    @Test
    void contextLoads() {
        stringRedisTemplate.opsForValue().set("uuid", UUID.randomUUID().toString());
        String uuid = stringRedisTemplate.opsForValue().get("uuid");
        System.out.println(uuid);
    }

    /**
     * 测试向List中存取值
     */
    @Test
    void testList(){
        //从左边放值
        stringRedisTemplate.opsForList().leftPush("list1","a");
        stringRedisTemplate.opsForList().leftPush("list1","b");
        stringRedisTemplate.opsForList().leftPush("list1","c");

        String value = stringRedisTemplate.opsForList().leftPop("list1");
//        Assertions.assertEquals("c",value);
        System.out.println(value);
    }

    /**
     * 测试向set中放值
     */
    @Test
    void testSet(){
        stringRedisTemplate.opsForSet().add("set1","a");
        stringRedisTemplate.opsForSet().add("set1","b","c");
        //检查set中是否存在该值
        Boolean isMember = stringRedisTemplate.opsForSet().isMember("set1", "c");
        System.out.println(isMember);
    }

    /**
     * 测试有序集合zset
     */
    @Test
    void testZset(){
        stringRedisTemplate.opsForZSet().add("zset1","a",1);
        stringRedisTemplate.opsForZSet().add("zset1","b",3);
        stringRedisTemplate.opsForZSet().add("zset1","c",2);
        //获取集合中所有元素
        Set<String> zset1 = stringRedisTemplate.opsForZSet().range("zset1", 0, -1);
        System.out.println(zset1);
        //获取集合中指定元素
        Set<String> zset11 = stringRedisTemplate.opsForZSet().rangeByScore("zset1", 0, 2);
        System.out.println(zset11);
        //获取集合中指定元素的分数
        Double score = stringRedisTemplate.opsForZSet().score("zset1", "a");
        System.out.println("score:" + score);
        //获取集合中指定元素的排名
        Long rankA = stringRedisTemplate.opsForZSet().rank("zset1", "a");
        Long rankB = stringRedisTemplate.opsForZSet().rank("zset1", "b");
        Long rankC = stringRedisTemplate.opsForZSet().rank("zset1", "c");
        System.out.println("rankA:" + rankA);
        System.out.println("rankB:" + rankB);
        System.out.println("rankC:" + rankC);
        //获取最大score的元素
        ZSetOperations.TypedTuple<String> zset12 = stringRedisTemplate.opsForZSet().popMax("zset1");
        System.out.println("Max: "+ zset12.getValue() + ":"+zset12.getScore());
    }

    /**
     * 测试Hash
     */
    @Test
    void testHash(){
        String mapName = "amap";
        stringRedisTemplate.opsForHash().put(mapName,"name","张三");
        stringRedisTemplate.opsForHash().put(mapName,"age","18");

        System.out.println(stringRedisTemplate.opsForHash().get(mapName, "name"));

    }

    @Test
    void testUtils(){
        System.out.println(redisUtil.get("count-people"));
        Person person = (Person) redisUtil.get("person");
        System.out.println(person);
    }

    /**
     * 测试存放Hash
     */
    @Test
    void testAddHash(){
        Person person1 = new Person(1L,"张三",19,new Date());
        Person person2 = new Person(2L,"李四",19,new Date());
//        stringRedisTemplate.opsForHash().put("pserson","name","张三");
        redisUtil.putHash("person",person1.getId().toString(),person1);
        redisUtil.putHash("person",person2.getId().toString(),person2.getName());
    }


    @Test
    void testGetHash(){
        Map<Object, Object> personEntries = redisUtil.getHashEntries("person");
        System.out.println(personEntries);
        Person person = (Person)redisUtil.getHashValue("person", "1");
        System.out.println(person);
        String person2Name = redisUtil.getHashStringValue("person", "2");
        System.out.println(person2Name);
    }


}
