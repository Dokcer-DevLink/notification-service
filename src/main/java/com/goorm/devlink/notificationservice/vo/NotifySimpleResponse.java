package com.goorm.devlink.notificationservice.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class NotifySimpleResponse {

    private String notificationUuid;
    private String message;

    public static NotifySimpleResponse getInstance(String notificationUuid, String message){
        return NotifySimpleResponse.builder()
                .notificationUuid(notificationUuid)
                .message(message)
                .build();
    }
}
