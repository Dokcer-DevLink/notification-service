package com.goorm.devlink.notificationservice.controller;


import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.dto.NotifyType;
import com.goorm.devlink.notificationservice.service.NotificationService;
import com.goorm.devlink.notificationservice.util.MessageUtil;
import com.goorm.devlink.notificationservice.vo.NotifyMessageResponse;
import com.goorm.devlink.notificationservice.vo.NotifySimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;
    private final MessageUtil messageUtil;


    // 알림 등록
    @KafkaListener(
            topics = "#{'${data.kafka.topicName}'}",
            groupId = "#{'${data.kafka.groupId}'}"
    )
    public void listen(NotifyDto notifyDto){
        log.info(notifyDto.toString());
        notificationService.saveNotification(notifyDto);
        if(notifyDto.getNotifyType().equals(NotifyType.MENTORING_ACCEPT) ||
                notifyDto.getNotifyType().equals(NotifyType.MENTORING_ACCEPT) ){
            notificationService.doCheckApplyNotify(notifyDto);
        }
    }

    // 알림 조회
    @GetMapping("/api/notification/my")
    public ResponseEntity<Slice<NotifyMessageResponse>> getMyNotificationList(@RequestHeader("userUuid") String userUuid){
        if( userUuid.isEmpty() ) { throw new NoSuchElementException(messageUtil.getUserUuidEmptyMessage()); }
        Slice<NotifyMessageResponse> notifyMessageResponses = notificationService.findMyNotificationList(userUuid);
        return ResponseEntity.ok(notifyMessageResponses);
    }

    @GetMapping("/api/notification/check")
    public ResponseEntity<NotifySimpleResponse> checkNotification(@RequestParam String notificationUuid){
        if( notificationUuid.isEmpty()) {
            throw  new NoSuchElementException(messageUtil.getNotificationUuidEmptyMessage()); }
        notificationService.checkNotification(notificationUuid);
        return ResponseEntity.ok(NotifySimpleResponse.getInstance(notificationUuid,messageUtil.getCheckMessage()));
    }

}
