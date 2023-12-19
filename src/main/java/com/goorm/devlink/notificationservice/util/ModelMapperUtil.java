package com.goorm.devlink.notificationservice.util;

import com.goorm.devlink.notificationservice.dto.NotifyDto;
import com.goorm.devlink.notificationservice.entity.MentoringNotification;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@RequiredArgsConstructor
public class ModelMapperUtil {

    private final ModelMapper modelMapper;

    public MentoringNotification convertToNotification(NotifyDto notifyDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(notifyDto, MentoringNotification.class);
    }
}
