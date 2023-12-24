package com.goorm.devlink.notificationservice.config;


import com.goorm.devlink.notificationservice.util.MessageUtil;
import com.goorm.devlink.notificationservice.util.ModelMapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
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

    @Bean
    public MessageUtil messageUtil(MessageSource messageSource){
        return new MessageUtil(messageSource);
    }
}
