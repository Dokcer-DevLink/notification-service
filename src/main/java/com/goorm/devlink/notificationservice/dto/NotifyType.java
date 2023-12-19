package com.goorm.devlink.notificationservice.dto;

public enum NotifyType {
    MENTORING_APPLY("멘토링 제안이 들어왔습니다."),
    MENTORING_ACCEPT("멘토링이 수락되었습니다."),
    MENTORING_REJECT("멘토링이 거절되었습니다.");

    private String message;
    NotifyType(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
