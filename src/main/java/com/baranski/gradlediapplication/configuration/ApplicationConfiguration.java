package com.baranski.gradlediapplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public NonSpringComponent nonSpringComponent() {
        return new NonSpringComponent("I am non spring component but I can still be injected thanks to @Bean!");
    }

    @Bean("nonSpringBean")
    public NonSpringComponentByName nonSpringComponentByName(){
        return new NonSpringComponentByName("I can still be injected thanks to @Bean via name!");
    }
}
