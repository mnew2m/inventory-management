package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.request.UserTestReqDto;
import com.inventory.inventorymanagement.dto.response.UserTestResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/test")
    public UserTestResDto post(@RequestBody UserTestReqDto dto) {
        return UserTestResDto.toEntity(dto);
    }
}
