package com.inventory.inventorymanagement.service;

import com.inventory.inventorymanagement.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

}
