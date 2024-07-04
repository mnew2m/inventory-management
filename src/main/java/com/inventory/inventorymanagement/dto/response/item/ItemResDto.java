package com.inventory.inventorymanagement.dto.response.item;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ItemResDto {
    // 아이템 seq
    private int itemSeq;

    // 구매처
    private String site;

    // 카테고리명
    private String categoryName;

    // 이름
    private String name;

    // 메모
    private String memo;

    // 가격
    private int price;

    // 수량
    private int cnt;

    // 구매날짜
    private LocalDate boughtDate;
}
