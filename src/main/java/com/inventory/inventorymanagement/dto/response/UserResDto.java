package com.inventory.inventorymanagement.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResDto {
    // 아이디
    private String userId;

    // 이름
    private String username;
}
