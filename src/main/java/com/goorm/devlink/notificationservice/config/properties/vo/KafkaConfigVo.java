package com.goorm.devlink.notificationservice.config.properties.vo;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Getter @Setter
@Slf4j
public class KafkaConfigVo {

    private final String topicName;
    private final String bootstrapServerUrl;
    private final String groupId;

    @PostConstruct
    public void init(){
        log.info("topicName {}",topicName);
        log.info("bootstrapServerUrl {} ", bootstrapServerUrl);
        log.info("groupId {}", groupId);
    }
}
