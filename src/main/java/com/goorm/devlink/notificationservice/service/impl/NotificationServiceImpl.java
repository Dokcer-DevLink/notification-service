package com.goorm.devlink.notificationservice.service.impl;

import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.dto.NotifyStatus;
import com.goorm.devlink.notificationservice.dto.NotifyType;
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
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {


    private final ModelMapperUtil modelMapperUtil;
    private final NotificationRepository notificationRepository;

    @Override
    public Slice<NotifyMessageResponse> findMyNotificationList(String userUuid) {
        PageRequest pageRequest = PageRequest.of(0,8, Sort.Direction.DESC,"createdDate");
        Slice<MentoringNotification> notificationList =
                notificationRepository.findByRecipientUuidAndNotifyStatus(userUuid,NotifyStatus.UNCHKECK,pageRequest);
        return notificationList.map(notification -> NotifyMessageResponse.getInstance(notification));

    }

    @Override
    @Transactional
    public void saveNotification(NotifyDto notifyDto) {
        MentoringNotification mentoringNotification = modelMapperUtil.convertToNotification(notifyDto);
        mentoringNotification.updateStatus(NotifyStatus.UNCHKECK);
        notificationRepository.save(mentoringNotification);
    }

    @Override
    @Transactional
    public void doCheckApplyNotify(NotifyDto notifyDto) {
        MentoringNotification notification = findMentoringNotification(notifyDto);
        notification.updateStatus(NotifyStatus.CHECK);
        notificationRepository.save(notification);
    }

    @Override
    @Transactional
    public void checkNotification(String notificationUuid) {
        MentoringNotification notification = findMentoringNotification(notificationUuid);
        notification.updateStatus(NotifyStatus.CHECK);
        notificationRepository.save(notification);
    }

    private MentoringNotification findMentoringNotification(NotifyDto notifyDto){
        return notificationRepository
                .findByApplyUuidAndNotifyType(notifyDto.getApplyUuid(), NotifyType.MENTORING_APPLY)
                .orElseThrow(()-> { throw new NoSuchElementException(""); });
    }

    private MentoringNotification findMentoringNotification(String notificationUuid){
        return  notificationRepository.findByNotificationUuid(notificationUuid)
                        .orElseThrow(()-> { throw new NoSuchElementException("");});
    }
}
