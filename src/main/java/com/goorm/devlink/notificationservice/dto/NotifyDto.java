package com.goorm.devlink.notificationservice.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class NotifyDto implements Serializable {

    public enum NotifyType{
        MENTORING_APPLY, MENTORING_ACCEPT, MENTORING_REJECT;
    }
    private String senderUuid;
    private String receiverUuid;
    private NotifyType notifyType;
}
