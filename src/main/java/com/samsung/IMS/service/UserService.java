package com.samsung.IMS.service;

import com.samsung.IMS.model.ItemVO;
import com.samsung.IMS.model.db.Item;
import com.samsung.IMS.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private ItemRepository itemRepository;

    public List<ItemVO> getAvailableItems() {
        List<Item> items = itemRepository.findAll();

        List<ItemVO> itemsVO = new ArrayList<>();

        for (Item item : items) {
            if (item.getStockQuantity() > 0) {
                itemsVO.add(
                        ItemVO.builder()
                                .itemId(item.getItemId())
                                .itemName(item.getItemName())
                                .category(item.getCategory())
                                .stockQuantity(item.getStockQuantity())
                                .updateDate(item.getUpdateDate())
                                .build()
                );
            }
        }

        return itemsVO;
    }
}
