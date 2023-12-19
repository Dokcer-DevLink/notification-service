package com.goorm.devlink.notificationservice.repository;

import com.goorm.devlink.notificationservice.entity.MentoringNotification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<MentoringNotification,Long> {
    Slice<MentoringNotification> findByRecipientUuid(String userUuid, Pageable pageable);
}
