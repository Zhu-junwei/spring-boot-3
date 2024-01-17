package com.atguigu.actuator.health;

/**
 * @author 朱俊伟
 * @since 2023/11/10 12:27
 */

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 1、实现 HealthIndicator 接口来定制组件的健康状态对象（Health） 返回
 * 2、继承AbstractHealthIndicator类
 */
@Component
public class MyHealthIndicator extends AbstractHealthIndicator {

    /**
     * 健康检查
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //自定义检查方法

        int check = Math.random() > 0.5 ? 1 : 0;
        if(check == 1){
            //存活
            builder.up()
                    .withDetail("code","1000")
                    .withDetail("msg","活的很健康")
                    .withDetail("data","我的名字叫haha")
                    .build();
        }else {
            //下线
            builder.down()
                    .withDetail("code","1001")
                    .withDetail("msg","死的很健康")
                    .withDetail("data","我的名字叫haha完蛋")
                    .build();
        }

    }
}