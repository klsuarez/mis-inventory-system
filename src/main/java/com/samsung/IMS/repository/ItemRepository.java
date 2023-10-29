package com.samsung.IMS.repository;

import com.samsung.IMS.model.db.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
