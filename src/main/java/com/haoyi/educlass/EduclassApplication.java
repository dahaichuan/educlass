package com.haoyi.educlass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haoyi.educlass.mapper")
public class EduclassApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduclassApplication.class, args);
    }

}
