# Spring发布-订阅模式：解耦与异步通信的高效实现

## 前言

> Spring框架通过发布订阅模式为组件间通信提供了高效且松散耦合的解决方案，提升了系统的灵活性和扩展性。

## 一、发布订阅模式的基本概念

发布订阅模式，又称为观察者模式（Observer
Pattern）的一种变体，是一种基于消息传递的设计模式。在这个模式中，主要涉及三个核心角色：发布者（Publisher）、订阅者（Subscriber）和消息代理（Message
Broker）。

## 二、发布订阅模式的实现

下面通过发布订阅模式实现一个示例：在用户注册成功后，系统自动发送邮件通知用户。

### 1. 定义事件

定义事件类，事件类通常继承自`org.springframework.context.ApplicationEvent`

我们可以定义一个`UserRegisteredEvent`类来表示用户注册成功的事件

```java
package com.zjw.envent;

import com.zjw.domain.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author zjw
 * @since 2025/01/11 18:49
 */
@Getter
public class UserRegisteredEvent extends ApplicationEvent {

    // 这里的User是一个包含用户相关信息的实体类
    private User user;

    // source：事件的源对象，用于表明这个事件是由哪个对象触发的
    // 具体作用下面订阅事件中解释
    public UserRegisteredEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
```

### 2. 发布事件

发布事件的组件需要获取 `ApplicationEventPublisher` 实例，并通过它来发布事件

在用户注册操作成功完成后，发布用户注册事件
```java
package com.zjw.servie;

import com.zjw.domain.User;
import com.zjw.envent.UserRegisteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @author zjw
 * @since 2025/01/11 18:49
 */
@Service
@AllArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void registerUser(User user) {
        // 执行用户注册逻辑，如保存用户信息到数据库等

        // 注册成功后发布事件
        UserRegisteredEvent event = new UserRegisteredEvent(this, user);
        eventPublisher.publishEvent(event);
    }
}
```

### 3.订阅事件

#### 3.1 实现ApplicationListener接口

一种实现方式是实现`ApplicationListener`接口，并在`onApplicationEvent`方法中处理事件

```java
package com.zjw.listener;

import com.zjw.envent.UserRegisteredEvent;
import com.zjw.servie.APIUserRegistrationService;
import com.zjw.servie.UserRegistrationService;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zjw
 * @since 2025/01/11 18:55
 */

/**
 * 通过实现 ApplicationListener 接口，并指定监听的事件类型，可以监听到 Spring 容器中发布的事件。
 */
@Component
public class UserRegisteredListener implements ApplicationListener<UserRegisteredEvent> {

    @Override
    public void onApplicationEvent(UserRegisteredEvent event) {
        // 监听到用户注册事件，打印用户信息
        Object eventSource = event.getSource();
        // 区分事件的来源做不同的处理
        if (eventSource instanceof UserRegistrationService) {
            System.out.println("User website registered: " + event.getUser());
        } else if (eventSource instanceof APIUserRegistrationService) {
            System.out.println("User API registered: " + event.getUser());
        }
    }
}
```

#### 3.2 通过注解@EventListener

另一种实现方式是通过注解`@EventListener`来监听事件

```java
package com.zjw.servie;

import com.zjw.envent.UserRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zjw
 * @since 2025/01/11 19:03
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 监听UserRegisteredEvent事件, 并发送邮件通知
     * @param event 用户注册事件
     */
    @EventListener
    @Async
    @Override
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        System.out.println("EmailService 发送邮件通知给用户：" + event.getUser().getName());
    }
}
```

这里的`@Async`注解用于异步处理，可以提升系统的响应速度。
