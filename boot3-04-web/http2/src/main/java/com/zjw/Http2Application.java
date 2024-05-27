package com.zjw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class Http2Application {

    // 用于获取环境属性
    private final Environment environment;

    public Http2Application(Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(Http2Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello Http2";
    }

    // 用于获取环境属性
    @EventListener(WebServerInitializedEvent.class)
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
        String contextPath = environment.getProperty("server.servlet.context-path", "");
        String protocol = environment.getProperty("server.ssl.key-store") != null ? "https" : "http";
        String hostAddress = environment.getProperty("server.address", "localhost");

        log.info("Application is running at {}://{}:{}{}", protocol, hostAddress, port, contextPath);
    }

}
