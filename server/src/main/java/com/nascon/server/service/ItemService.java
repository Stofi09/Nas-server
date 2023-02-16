package com.nascon.server.service;

import com.nascon.server.dto.CustomerRequest;
import com.nascon.server.dto.CustomerResponse;
import com.nascon.server.dto.ItemRequest;
import com.nascon.server.dto.ItemResponse;
import com.nascon.server.model.Customer;
import com.nascon.server.model.Item;
import com.nascon.server.repository.CustomerRepository;
import com.nascon.server.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }
    public void createItem(ItemRequest request) {
        Item item = Item.builder()
                .name(request.getName())
                .amount(request.getAmount())
                .isAvailable(request.isAvailable())
                .build();
        repository.save(item);
        log.info("Product is save: " + item.toString());
    }

    public List<ItemResponse> findAll() {
        List<Item> items = repository.findAll();
        return items.stream().map(this:: mapToItemResponse).toList();
    }

    private ItemResponse mapToItemResponse(Item item) {
        return ItemResponse.builder()
                .Id(item.getId())
                .name(item.getName())
                .amount(item.getAmount())
                .isAvailable(item.isAvailable())
                .build();
    }
}
