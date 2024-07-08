package com.inventory.inventorymanagement.dto.response.cycle;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CycleResDto {
    // 아이템 ID
    private int itemId;

    // 구매처
    private String site;

    // 카테고리명
    private String categoryName;

    // 상품명
    private String name;

    // 메모
    private String memo;

    // 가격
    private int price;

    // 수량
    private int cnt;

    // 마지막 교체일
    private LocalDate lastCycleDate;
}
