package com.example.emailservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderEvent {
    private String status; //pending, progress , completed
    private String message;
    private Order order;
}
