package com.microservices.inventoryservice.services;

import com.microservices.inventoryservice.dto.InventoryResponse;
import com.microservices.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode){
       return inventoryRepository.findBySkuCodeIn(skuCode).stream()
               .map(inventory ->
                   InventoryResponse.builder().skuCode(inventory.getSkuCode())
                           .isInStock(inventory.getQuantity() > 0)
                           .build()
               ).toList();
    }
}
