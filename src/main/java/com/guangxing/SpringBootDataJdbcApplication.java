package com.guangxing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//批量扫描Mapper接口
@MapperScan(value = "com.guangxing.mapper")
public class SpringBootDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataJdbcApplication.class, args);
    }

}
