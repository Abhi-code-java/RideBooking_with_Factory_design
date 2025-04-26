package com.texi.texi.entity;

import com.texi.texi.enums.CompanyType;
import com.texi.texi.enums.TranspostType;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class RiderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    @Column(name = "from_location")
    private String from;
    @Column(name = "`to`")
    private String to;
    @Enumerated(EnumType.STRING)
    private TranspostType transpostType;
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    private RiderEntity(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.from = builder.from;
        this.to = builder.to;
        this.transpostType =builder.transpostType;
        this.companyType = builder.companyType;
    }
    public static class Builder{
        private int id;
        private String userName;
        private String from;
        private String to;
        private TranspostType transpostType;
        private CompanyType companyType;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setFrom(String from) {
            this.from = from;
            return this;
        }

        public Builder setTo(String to) {
            this.to = to;
            return this;
        }

        public Builder setTranspostType(TranspostType transpostType) {
            this.transpostType = transpostType;
            return this;
        }

        public Builder setCompanyType(CompanyType companyType) {
            this.companyType = companyType;
            return this;
        }
        public RiderEntity build(){
            if (userName == null || userName.trim().isEmpty()) {
                throw new IllegalArgumentException("Username is required");
            }
            if (from == null || from.trim().isEmpty()) {
                throw new IllegalArgumentException("From location is required");
            }
            if (to == null || to.trim().isEmpty()) {
                throw new IllegalArgumentException("To location is required");
            }
            if (transpostType == null) {
                throw new IllegalArgumentException("Transport Type is required");
            }
            if (companyType == null) {
                throw new IllegalArgumentException("Company Type is required");
            }
            return new RiderEntity(this);
        }
    }
    }
