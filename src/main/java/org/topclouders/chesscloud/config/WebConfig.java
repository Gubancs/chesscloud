package org.topclouders.chesscloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.concurrent.TimeUnit;

/**
 * Created by kokeny on 10/11/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.topclouders", includeFilters = {@ComponentScan.Filter(
        value = Controller.class,
        type = FilterType.ANNOTATION
), @ComponentScan.Filter(
        value = RestController.class,
        type = FilterType.ANNOTATION
)})
public class WebConfig extends WebMvcConfigurerAdapter {


    /**
     * Add custom resource handlers to the resource handler registry
     *
     * @param registry Registry of the resource handlers.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

        registry.addResourceHandler("/views/**")
                .addResourceLocations("/WEB-INF/views/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());

        registry.addResourceHandler("/index.html").addResourceLocations("/WEB-INF/index.html");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".html");

        return resolver;
    }
}

