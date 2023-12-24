package com.goorm.devlink.notificationservice.util;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;


@RequiredArgsConstructor
public class MessageUtil {

    private final MessageSource messageSource;

    public String getUserUuidEmptyMessage(){
        return getMessage("request.empty.userUuid");
    }

    public String getNotificationUuidEmptyMessage(){
        return getMessage("request.empty.notificationUuid");
    }

    public String getCheckMessage(){
        return getMessage("response.notify.check");
    }

    public String getNotificationNoSuchMessage(String notificationUuid){
        return getMessage("request.nosuch.notificationUuid",new String[]{ notificationUuid});
    }

    public String getApplyNoSuchMessage(String applyUuid){
        return getMessage("request.nosuch.applyUuid",new String[] {applyUuid});
    }
    private String getMessage(String messageCode){
        return messageSource.getMessage(messageCode,new String[]{}, Locale.KOREA);
    }

    private String getMessage(String messageCode, String[] parameters){
        return messageSource.getMessage(messageCode, parameters, Locale.KOREA);
    }
}
