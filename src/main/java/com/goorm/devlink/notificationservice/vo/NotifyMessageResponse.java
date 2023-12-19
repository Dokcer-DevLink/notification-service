package com.goorm.devlink.notificationservice.vo;

import com.goorm.devlink.notificationservice.dto.NotifyType;
import com.goorm.devlink.notificationservice.entity.MentoringNotification;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class NotifyMessageResponse {

    private String message;
    private NotifyType notifyType;
    private String applyUuid;
    private String postUuid;
    private String senderUuid;
    private String recipientUuid;

    public static NotifyMessageResponse getInstance(MentoringNotification notification){
        return NotifyMessageResponse.builder()
                .message(notification.getNotifyType().getMessage())
                .notifyType(notification.getNotifyType())
                .applyUuid(notification.getApplyUuid())
                .postUuid(notification.getPostUuid())
                .senderUuid(notification.getSenderUuid())
                .recipientUuid(notification.getRecipientUuid())
                .build();
    }


}
