package com.goorm.devlink.notificationservice.config;


import com.goorm.devlink.notificationservice.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ModelMapperUtil modelMapperUtil(ModelMapper modelMapper){
        return new ModelMapperUtil(modelMapper);
    }
}
