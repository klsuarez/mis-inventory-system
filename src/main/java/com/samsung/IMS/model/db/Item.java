package com.samsung.IMS.model.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long itemId;

    private String itemName;

    private String category;

    private int stockQuantity;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;
}