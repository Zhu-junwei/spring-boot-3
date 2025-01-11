package com.zjw;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zjw
 * @since 2025/01/11 18:42
 */
@SpringBootApplication
@EnableAsync
@Slf4j
@AllArgsConstructor
public class MainApplication {

    // 用于获取环境属性
    private final Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
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
