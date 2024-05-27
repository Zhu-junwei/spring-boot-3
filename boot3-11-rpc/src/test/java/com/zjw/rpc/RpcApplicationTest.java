package com.zjw.rpc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
@Slf4j
class RpcApplicationTest {

    @Test
    void contextLoads() {
    }

    /**
     * WebClient
     * 测试接口：https://api.aa1.cn/doc/idcard.html
     */
    @SneakyThrows
    @Test
    void testWebClient() {
        String baseUrl = "http://niningqi.com/";
        String restUrl = baseUrl + "idcard/gen?district=上海市&sex=0&num=3&date=1998";
        Mono<String> resp = WebClient.create().method(HttpMethod.GET).uri(restUrl).retrieve().bodyToMono(String.class);
        //订阅结果
        resp.subscribe(responseData -> {
            log.info(responseData);
        }, e -> {
            log.info("error:" + e.getMessage());
        });
        //主线程等待， 一切都是为了查看到异步结果
        Thread.sleep(3000);
    }

}
