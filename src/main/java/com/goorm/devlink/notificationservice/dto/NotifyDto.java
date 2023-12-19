package com.goorm.devlink.notificationservice.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class NotifyDto implements Serializable {

    private String notificationUuid;
    private String senderUuid;
    private String recipientUuid;
    private NotifyType notifyType;

}
