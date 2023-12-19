package com.goorm.devlink.notificationservice.repository;

import com.goorm.devlink.notificationservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
