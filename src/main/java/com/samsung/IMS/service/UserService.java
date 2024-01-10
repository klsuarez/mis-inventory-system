package com.samsung.IMS.service;

import com.samsung.IMS.model.ItemVO;
import com.samsung.IMS.db.entity.Item;
import com.samsung.IMS.db.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (item.getStock() > 0) {
                itemsVO.add(
                        ItemVO.builder()
                                .itemId(item.getItemId())
                                .itemName(item.getItemName())
                                .category(item.getCategory())
                                .stockQuantity(item.getStock())
                                .updateDate(item.getUpdateDate())
                                .build()
                );
            }
        }

        return itemsVO;
    }
}
