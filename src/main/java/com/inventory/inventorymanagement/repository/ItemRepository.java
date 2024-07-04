package com.inventory.inventorymanagement.repository;

import com.inventory.inventorymanagement.entity.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemList, Integer> {
}
