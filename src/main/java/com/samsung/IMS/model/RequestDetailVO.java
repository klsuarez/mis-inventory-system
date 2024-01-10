package com.samsung.IMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDetailVO {

    private int quantity;

    private int requestId;

    private int itemId;

    private int durationDays;

    private String reason;
}