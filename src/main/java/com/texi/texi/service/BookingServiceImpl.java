package com.texi.texi.service;

import com.texi.texi.dto.BookingRequestDto;
import com.texi.texi.dto.BookingResponseDto;
import com.texi.texi.entity.RiderEntity;
import com.texi.texi.mapper.RiderMapping;
import com.texi.texi.repositopry.RideEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    private RideEntityRepository rideEntityRepository;

    public BookingServiceImpl(RideEntityRepository rideEntityRepository) {
        this.rideEntityRepository = rideEntityRepository;
    }

    @Override
    public BookingResponseDto createBooking(BookingRequestDto dto) {
        RiderEntity entity=new RiderEntity.Builder()
                .setUserName(dto.getUserName())
                .setCompanyType(dto.getCompanyType())
                .setTranspostType(dto.getTranspostType())
                .setFrom(dto.getFrom())
                .setTo(dto.getTo())
                .build();
rideEntityRepository.save(entity);
        return RiderMapping.fromEntity(entity);
    }
}
