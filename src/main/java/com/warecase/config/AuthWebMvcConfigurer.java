package com.warecase.config;

import com.warecase.filter.TokenHandlerInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
public class AuthWebMvcConfigurer implements WebMvcConfigurer {

    // 注入 TokenHandlerInterceptor
    @Resource
    TokenHandlerInterceptor authHandlerInterceptor;

    /**
     * 给除了 /login 的接口都配置拦截器,拦截转向到 authHandlerInterceptor
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authHandlerInterceptor)
                .addPathPatterns("/**")//配置拦截路径
                .excludePathPatterns("/")// 放行路径
                .excludePathPatterns("/login")
                .excludePathPatterns("/*.html","/**/*.html","/*.js","/**/*.js","/*.css","/**/*.css","/*.png","/**/*.png","/*.jpg","/**/*.jpg","/*.ico");//放行路径
    }

    // 配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    // 配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    // 配置默认跳转页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}
