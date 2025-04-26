package com.texi.texi.controller;

import com.texi.texi.dto.BookingRequestDto;
import com.texi.texi.dto.BookingResponseDto;
import com.texi.texi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookRide")
public class BookingController {
    @Autowired
    private BookingService service;
    @PostMapping("/book")
            public ResponseEntity<BookingResponseDto> create(@RequestBody BookingRequestDto dto){
        return ResponseEntity.ok(service.createBooking(dto));
    }
}
