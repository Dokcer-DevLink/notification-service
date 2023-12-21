package com.goorm.devlink.notificationservice.entity;


import com.goorm.devlink.notificationservice.dto.NotifyStatus;
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
@SequenceGenerator(
        name="NOTIFICATION_SEQ_GENERATOR",
        sequenceName = "MENTORING_NOTIFICATION_SEQ",
        initialValue = 1,allocationSize = 1

)
public class MentoringNotification extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_SEQ_GENERATOR")
    @Column(name = "notification_id")
    private Long id;

    @Column(unique = true, name = "notification_uuid")
    private String notificationUuid;

    @Column(name = "apply_uuid")
    private String applyUuid;

    @Column(name = "post_uuid")
    private String postUuid;

    @Column(name = "sender_uuid")
    private String senderUuid;

    @Column(name = "recipient_uuid")
    private String recipientUuid;

    @Column(name = "notify_type")
    @Enumerated(EnumType.STRING)
    private NotifyType notifyType;

    @Column(name = "notify_status")
    @Enumerated(EnumType.STRING)
    private NotifyStatus notifyStatus;


    public void updateStatus(NotifyStatus notifyStatus) {
        this.notifyStatus = notifyStatus;
    }
}
