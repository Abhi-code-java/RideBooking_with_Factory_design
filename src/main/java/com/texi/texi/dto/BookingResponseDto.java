package com.texi.texi.dto;

import com.texi.texi.enums.CompanyType;
import com.texi.texi.enums.TranspostType;
import lombok.Data;

@Data
public class BookingResponseDto {
    private int id;
    private String userName;
    private String from;
    private String to;
    private TranspostType transpostType;
    private CompanyType companyType;
}
