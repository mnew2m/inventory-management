package com.inventory.inventorymanagement.dto.request.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemReqDto {
    // 유저 seq
    private int userSeq;

    // 기준 년도
    private String year;

    // 기준 월
    private String month;

    // 정렬 타입
    private String orderType;

    // 검색 타입
    private String searchType;

    // 검색어
    private String searchText;
}
