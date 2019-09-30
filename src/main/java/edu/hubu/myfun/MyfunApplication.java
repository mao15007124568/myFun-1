package edu.hubu.myfun;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.hubu.myfun.mapper")
public class MyfunApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyfunApplication.class, args);
    }

}
