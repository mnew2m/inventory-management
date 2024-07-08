package com.inventory.inventorymanagement.controller;

import com.inventory.inventorymanagement.dto.request.category.CategorySaveReqDto;
import com.inventory.inventorymanagement.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@RequestMapping("/category")
@RequiredArgsConstructor
@RestController
public class CategoryController extends DefaultRestController{
    private final CategoryService categoryService;

    /**
     * 카테고리 조회
     *
     * @param userId 유저 ID
     * */
    @PostMapping("/{userId}}")
    public DeferredResult<ResponseEntity<?>> getList(@PathVariable Integer userId) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 카테고리 등록
     *
     * @param dto dto
     * */
    @PostMapping("/")
    public DeferredResult<ResponseEntity<?>> save(@RequestBody CategorySaveReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 카테고리 수정
     *
     * @param dto dto
     * */
    @PutMapping("/")
    public DeferredResult<ResponseEntity<?>> modify(@RequestBody CategorySaveReqDto dto) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }

    /**
     * 카테고리 삭제
     *
     * @param categoryId 카테고리 ID
     * */
    @DeleteMapping("/{categoryId}")
    public DeferredResult<ResponseEntity<?>> delete(@PathVariable Integer categoryId) {
        try {
            return successResponse();
        } catch (Exception e) {
            log.error(e.getMessage());
            return failResponse(e);
        }
    }
}
