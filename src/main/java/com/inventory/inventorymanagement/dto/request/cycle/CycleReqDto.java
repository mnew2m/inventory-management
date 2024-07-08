package com.inventory.inventorymanagement.dto.request.cycle;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CycleReqDto {
    // 유저 ID
    private int userId;

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
