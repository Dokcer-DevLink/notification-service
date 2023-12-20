package com.goorm.devlink.notificationservice.repository;

import com.goorm.devlink.notificationservice.dto.NotifyStatus;
import com.goorm.devlink.notificationservice.dto.NotifyType;
import com.goorm.devlink.notificationservice.entity.MentoringNotification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<MentoringNotification,Long> {
    Slice<MentoringNotification> findByRecipientUuidAndNotifyStatus(String userUuid, NotifyStatus notifyStatus, Pageable pageable);
    MentoringNotification findByApplyUuidAndNotifyType(String applyUuid, NotifyType notifyType);

    MentoringNotification findByNotificationUuid(String notificationUuid);
}
