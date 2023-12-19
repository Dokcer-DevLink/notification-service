package com.goorm.devlink.notificationservice.service;

import com.goorm.devlink.notificationservice.dto.NotifyDto;

public interface NotificationService {
    void saveNotification(NotifyDto notifyDto);
}
