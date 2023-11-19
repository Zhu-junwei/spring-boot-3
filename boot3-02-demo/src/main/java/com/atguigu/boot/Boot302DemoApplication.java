package com.atguigu.boot;

import com.atguigu.boot.bean.Pig;
import com.atguigu.boot.bean.Sheep;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot302DemoApplication {

    public static void main(String[] args) {
        var ioc = SpringApplication.run(Boot302DemoApplication.class, args);
        Pig pig = ioc.getBean(Pig.class);
        System.out.println(pig);

        Sheep sheep = ioc.getBean(Sheep.class);
        System.out.println(sheep);
    }

}
