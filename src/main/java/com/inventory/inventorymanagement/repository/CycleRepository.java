package com.inventory.inventorymanagement.repository;

import com.inventory.inventorymanagement.entity.CycleItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleRepository extends JpaRepository<CycleItemList, Integer> {
}
