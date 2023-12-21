package com.goorm.devlink.notificationservice.service;

import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.vo.NotifyMessageResponse;
import org.springframework.data.domain.Slice;


public interface NotificationService {
    void saveNotification(NotifyDto notifyDto);

    Slice<NotifyMessageResponse> findMyNotificationList(String userUuid);

    void doCheckApplyNotify(NotifyDto notifyDto);

    void checkNotification(String notificationUuid);
}
