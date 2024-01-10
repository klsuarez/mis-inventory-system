package com.samsung.IMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDetailInfoVO {

    private Long userId;
    private Long itemId;
    private int quantity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;

}
