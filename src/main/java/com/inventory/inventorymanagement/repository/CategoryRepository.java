package com.inventory.inventorymanagement.repository;

import com.inventory.inventorymanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
