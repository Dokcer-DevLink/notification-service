package com.goorm.devlink.notificationservice.config;


import com.goorm.devlink.notificationservice.config.properties.vo.KafkaConfigVo;
import com.goorm.devlink.notificationservice.dto.NotifyDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaConfigVo kafkaConfigVo;

    @Bean
    public ProducerFactory<String, NotifyDto> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfigs(),null,new JsonSerializer<NotifyDto>());
    }
    @Bean
    public KafkaTemplate<String, NotifyDto> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
    @Bean
    public Map<String,Object> producerConfigs() {
        Map<String,Object> configurations = new HashMap<>();
        configurations.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfigVo.getBootstrapServerUrl());
        configurations.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configurations.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configurations.put(CommonClientConfigs.GROUP_ID_CONFIG,kafkaConfigVo.getGroupId());
        return configurations;
    }

    //Listener Config
    @Bean
    public ConsumerFactory<String,NotifyDto> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(),null,new JsonDeserializer<>(NotifyDto.class,false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,NotifyDto> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, NotifyDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public Map<String,Object> consumerConfigs(){
        Map<String,Object> configurations = new HashMap<>();
        configurations.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfigVo.getBootstrapServerUrl());
        configurations.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configurations.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configurations.put(CommonClientConfigs.GROUP_ID_CONFIG,kafkaConfigVo.getGroupId());
        configurations.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");// ??
        return configurations;

    }



}
