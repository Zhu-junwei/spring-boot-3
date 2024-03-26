package com.atguigu.boot;

import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import com.atguigu.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

/**
 * @author 朱俊伟
 */
@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);

        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println(sheep);

        // 从容器中获取user多实例对象
        User user1 = ioc.getBean("user22",User.class);
        User user2 = ioc.getBean("user22",User.class);
        System.out.println(user1);
        System.out.println(user2);
        // false 内存地址不一样
        System.out.println("user1 == user2 = " + (user1 == user2));
        // true 重写了equals方法，比较对象属性值
        System.out.println("user1.equals(user2) = " + user1.equals(user2));

        System.out.println("******获取容器中的对象id，判断条件注解******");
        List<String> nameList = Arrays.asList(ioc.getBeanDefinitionNames());
        System.out.println("nameList.contains(\"pig\") = " + nameList.contains("pig"));
        System.out.println("nameList.contains(\"cat\") = " + nameList.contains("cat"));
        System.out.println("nameList.contains(\"dog\") = " + nameList.contains("dog"));
        System.out.println("nameList.contains(\"cat1\") = " + nameList.contains("cat1"));
        System.out.println("nameList.contains(\"dog1\") = " + nameList.contains("dog1"));
    }

}
