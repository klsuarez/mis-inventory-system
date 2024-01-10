package com.samsung.IMS.db.repository;

import com.samsung.IMS.db.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
