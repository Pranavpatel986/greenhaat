package com.agro.bighaat.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AccountDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankName;
    private String ifscCode;
    private String branch;
}
