package com.hawliczek.tau.configuration;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc // tak jak w XML: <mvc:annotation-driven />
@ComponentScan({"com.hawliczek.tau"})
public class RestConfiguration extends WebMvcConfigurerAdapter 
{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> messageConverters)
    {
        super.configureMessageConverters(messageConverters);
    }
}