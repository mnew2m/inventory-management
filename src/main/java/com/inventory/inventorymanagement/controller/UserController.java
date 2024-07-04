package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.request.user.UserReqDto;
import com.inventory.inventorymanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController extends DefaultRestController{
    private final UserService userService;

    /**
     * 회원가입
     *
     * @param dto dto
     * */
    @PostMapping("/join")
    public DeferredResult<ResponseEntity<?>> join(@RequestBody UserReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 로그인
     *
     * @param dto dto
     * */
    @PostMapping("/login")
    public DeferredResult<ResponseEntity<?>> login(@RequestBody UserReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 비밀번호 변경
     *
     * @param dto dto
     * */
    @PostMapping("/password/modify")
    public DeferredResult<ResponseEntity<?>> modifyPassword(@RequestBody UserReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 회원 탈퇴
     *
     * @param dto dto
     * */
    @DeleteMapping("/password/modify")
    public DeferredResult<ResponseEntity<?>> delete(@RequestBody UserReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }
}
