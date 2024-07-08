package com.inventory.inventorymanagement.dto.request.item;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ItemSaveReqDto {
    // 카테고리 ID
    private int categoryId;

    // 상품명
    private String name;

    // 구매처
    private String site;

    // 메모
    private String memo;

    // 수량
    private int cnt;

    // 구매일
    private LocalDate boughtDate;

    // 가격
    private int price;
}
