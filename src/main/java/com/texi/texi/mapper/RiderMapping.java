package com.texi.texi.mapper;

import com.texi.texi.dto.BookingResponseDto;
import com.texi.texi.entity.RiderEntity;

public class RiderMapping {
    public static BookingResponseDto fromEntity(RiderEntity entity){
        BookingResponseDto dto=new BookingResponseDto();
        dto.setId(entity.getId());
        dto.setCompanyType(entity.getCompanyType());
        dto.setTranspostType(entity.getTranspostType());
        dto.setUserName(entity.getUserName());
        dto.setFrom(entity.getFrom());
        dto.setTo(entity.getTo());
        return dto;
    }
}
