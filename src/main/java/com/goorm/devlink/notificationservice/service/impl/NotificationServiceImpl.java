package com.goorm.devlink.notificationservice.service.impl;


import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.entity.Notification;
import com.goorm.devlink.notificationservice.repository.NotificationRepository;
import com.goorm.devlink.notificationservice.service.NotificationService;
import com.goorm.devlink.notificationservice.util.ModelMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {


    private final ModelMapperUtil modelMapperUtil;
    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(NotifyDto notifyDto) {
        Notification notification = modelMapperUtil.convertToNotification(notifyDto);
        notificationRepository.save(notification);
    }
}
