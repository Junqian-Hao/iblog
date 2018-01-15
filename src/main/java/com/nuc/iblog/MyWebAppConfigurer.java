package com.nuc.iblog;

import com.nuc.iblog.interceptor.ClLoginInterceptor;
import com.nuc.iblog.interceptor.MSLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ClLoginInterceptor()).addPathPatterns("/cl/**");
        registry.addInterceptor(new MSLoginInterceptor()).addPathPatterns("/ms/**");
        super.addInterceptors(registry);
    }
}
