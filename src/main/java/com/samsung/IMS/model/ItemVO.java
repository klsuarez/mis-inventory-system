package com.samsung.IMS.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemVO {
    private Long itemId;

    private String itemName;

    private String category;

    private int stockQuantity;

    private LocalDateTime updateDate;
}
