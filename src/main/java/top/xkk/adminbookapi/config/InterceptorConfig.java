package top.xkk.adminbookapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xkk.adminbookapi.interceptor.AuthorizationInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(authorityInterceptor()).addPathPatterns("/**");
    }

    @Bean
    public AuthorizationInterceptor authorityInterceptor() {
        return new AuthorizationInterceptor();
    }
}
