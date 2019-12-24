package top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.philxin.interceptor.UserInterceptor;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "top.philxin.mapper")
//@ComponentScan(basePackages = "top.philxin",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)})
public class Demo1SpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(Demo1SpringBootApplication.class, args);
    }
}
