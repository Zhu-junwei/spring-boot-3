package com.atguigu;

import com.atguigu.bean.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

/**
 * @author 朱俊伟
 */
class DemoTest {

    @Test
    @SneakyThrows
    public void testObject2Yaml(){
        Person person = Person.builder()
                .id(1L)
                .name("张三")
                .email("110@gamil.com")
                .age(18)
                .build();
        YAMLMapper yamlMapper = new YAMLMapper();
        String s = yamlMapper.writeValueAsString(person);
        System.out.println(s);


        YAMLFactory yamlFactory = new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER);
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        String s1 = objectMapper.writeValueAsString(person);
        System.out.println(s1);
    }
}