package com.inventory.inventorymanagement.dto.request.category;

import com.inventory.inventorymanagement.entity.enums.CategoryType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorySaveReqDto {
    // 유저 ID
    private Integer userId;

    // 카테고리 타입
    private CategoryType type;

    // 카테고리 명
    private String name;

    // 순서
    private int seq;
}
