package com.inventory.inventorymanagement.service;

import com.inventory.inventorymanagement.repository.CycleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CycleService {
    private final CycleRepository cycleRepository;

}
