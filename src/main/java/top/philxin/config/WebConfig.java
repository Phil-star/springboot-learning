package top.philxin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.philxin.converter.String2DateConverter;
import top.philxin.interceptor.UserInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 转换器
     * 1. 将String 转换为 Date
     */
//    @Autowired
//    ConfigurableConversionService conversionService;
//    @PostConstruct
//    public void addConverter() {
//        conversionService.addConverter(new String2DateConverter());
//    }
//    @Bean
//    @Primary
//    public ConfigurableConversionService conversionService() {
//        return conversionService;
//    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new String2DateConverter());
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
    }



//    /**
//     * 设置静态资源访问路径
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/avatar").addResourceLocations("file:**");
//    }
}
