package top.xkk.adminbookapi;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("top.xkk.adminbookapi.mapper")
public class AdminBookApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBookApiApplication.class, args);
    }

}
