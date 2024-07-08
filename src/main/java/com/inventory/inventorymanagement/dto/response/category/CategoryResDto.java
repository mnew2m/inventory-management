package com.inventory.inventorymanagement.dto.response.category;

import com.inventory.inventorymanagement.entity.enums.CategoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResDto {
    // 카테고리 ID
    private int categoryId;

    // 카테고리 타입
    private CategoryType type;

    // 카테고리명
    private String name;

    // 순서
    private int seq;
}
