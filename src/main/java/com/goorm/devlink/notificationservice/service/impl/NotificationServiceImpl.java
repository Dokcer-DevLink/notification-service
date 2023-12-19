package com.goorm.devlink.notificationservice.service.impl;

import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.entity.MentoringNotification;
import com.goorm.devlink.notificationservice.repository.NotificationRepository;
import com.goorm.devlink.notificationservice.service.NotificationService;
import com.goorm.devlink.notificationservice.util.ModelMapperUtil;
import com.goorm.devlink.notificationservice.vo.NotifyMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {


    private final ModelMapperUtil modelMapperUtil;
    private final NotificationRepository notificationRepository;

    @Override
    public void saveNotification(NotifyDto notifyDto) {
        MentoringNotification mentoringNotification = modelMapperUtil.convertToNotification(notifyDto);
        notificationRepository.save(mentoringNotification);
    }

    @Override
    public Slice<NotifyMessageResponse> findMyNotificationList(String userUuid) {
        PageRequest pageRequest = PageRequest.of(0,8, Sort.Direction.DESC,"createdDate");
        Slice<MentoringNotification> notificationList = notificationRepository.findByRecipientUuid(userUuid,pageRequest);
        return notificationList.map(notification -> NotifyMessageResponse.getInstance(notification));

    }
}
