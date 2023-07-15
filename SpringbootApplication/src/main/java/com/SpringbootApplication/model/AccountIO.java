package com.SpringbootApplication.model;

import lombok.Data;

@Data
public class AccountIO {

    private Long accountNumber;

    private String customerName;

    private String customerAddress;

    private Long phoneNumber;
}
