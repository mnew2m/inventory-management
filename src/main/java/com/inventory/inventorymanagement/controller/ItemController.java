package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.request.item.ItemReqDto;
import com.inventory.inventorymanagement.dto.request.item.ItemSaveReqDto;
import com.inventory.inventorymanagement.dto.request.user.UserReqDto;
import com.inventory.inventorymanagement.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@RequestMapping("/item")
@RequiredArgsConstructor
@RestController
public class ItemController extends DefaultRestController{
    private final ItemService itemService;

    /**
     * 구매 내역 조회
     *
     * @param dto dto
     * */
    @GetMapping("/list")
    public DeferredResult<ResponseEntity<?>> getList(@RequestBody ItemReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 구매 내역 등록
     *
     * @param dto dto
     * */
    @PostMapping("/")
    public DeferredResult<ResponseEntity<?>> save(@RequestBody ItemSaveReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 구매 내역 수정
     *
     * @param dto dto
     * */
    @PutMapping("/")
    public DeferredResult<ResponseEntity<?>> modify(@RequestBody ItemSaveReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 구매 내역 삭제
     *
     * @param itemId 아이템 ID
     * */
    @DeleteMapping("/{itemId}")
    public DeferredResult<ResponseEntity<?>> delete(@PathVariable Integer itemId) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }
}
