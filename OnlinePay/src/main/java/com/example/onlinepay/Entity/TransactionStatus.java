package com.example.onlinepay.Entity;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
public class TransactionStatus implements Serializable {
    private String status;
    private String message;
    private String data;
}
