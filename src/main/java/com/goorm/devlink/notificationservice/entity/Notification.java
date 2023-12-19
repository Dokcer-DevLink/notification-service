package com.goorm.devlink.notificationservice.entity;


import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.dto.NotifyType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Notification extends BaseTimeEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String notificationUuid;

    @Column(name = "sender_uuid")
    private String senderUuid;

    @Column(name = "recipient_uuid")
    private String recipientUuid;

    @Column(name = "notify_type")
    @Enumerated(EnumType.STRING)
    private NotifyType notifyType;

}
