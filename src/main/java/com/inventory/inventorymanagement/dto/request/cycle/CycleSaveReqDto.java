package com.inventory.inventorymanagement.dto.request.cycle;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CycleSaveReqDto {
    // 카테고리 seq
    private int categorySeq;

    // 상품명
    private String name;

    // 메모
    private String memo;

    // 수량
    private int cnt;

    // 교체 주기
    private int cycle;

    // 마지막 교체일
    private LocalDate lastCycleDate;
}
