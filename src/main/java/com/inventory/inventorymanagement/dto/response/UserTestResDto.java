package com.inventory.inventorymanagement.dto.response;

import com.inventory.inventorymanagement.dto.request.UserTestReqDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTestResDto {
    private int id;
    private String name;

    public static UserTestResDto toEntity(UserTestReqDto dto) {
        return UserTestResDto.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
