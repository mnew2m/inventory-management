package com.inventory.inventorymanagement.dto.request.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserReqDto {
    // 아이디
    private String username;

    // 비밀번호
    @JsonIgnore
    private String password;
}
