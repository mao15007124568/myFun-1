package edu.hubu.myfun.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SessioncConfiguration implements WebMvcConfigurer {

    @Bean
    public SessionInterceptor getSessionInterceptor(){
        return new SessionInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List <String> pathPatterns = new ArrayList<String>();
        pathPatterns.add("/");
        pathPatterns.add("/css/**");
        pathPatterns.add("/images/**");
        pathPatterns.add("/js/**");
        pathPatterns.add("/less/**");
        pathPatterns.add("/fonts");
        pathPatterns.add("/callback");
        pathPatterns.add("/index");
        registry.addInterceptor(getSessionInterceptor())
                .excludePathPatterns(pathPatterns)
                .addPathPatterns("/**");
    }
}
