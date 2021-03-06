package com.micro.springsecurityuserdetails;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	
    	 registry.addViewController("/home").setViewName("home");
    	 registry.addViewController("/").setViewName("home");
         registry.addViewController("/hello").setViewName("hello");
         registry.addViewController("/login").setViewName("login");
         registry.addViewController("/403").setViewName("403");
    }
    
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
    	System.out.println("inside datasource");
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://172.27.59.60:3306/userbase");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }

    
    @Bean
	public InternalResourceViewResolver viewResolver() {
    	System.out.println("before mapping");
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
    

}