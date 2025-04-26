package com.texi.texi.service;

import com.texi.texi.dto.BookingRequestDto;
import com.texi.texi.dto.BookingResponseDto;

public interface BookingService {
    BookingResponseDto createBooking(BookingRequestDto dto);
}
