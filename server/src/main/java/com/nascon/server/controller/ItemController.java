package com.nascon.server.controller;

import com.nascon.server.dto.ItemRequest;
import com.nascon.server.dto.ItemResponse;
import com.nascon.server.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @RequestMapping("/test")
    public String testController() {
        return "sikerult";
    }
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createItem(@RequestBody ItemRequest itemRequest){
        service.createItem(itemRequest);
        return itemRequest.getName();
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponse> getAllProducts(){
        return service.findAll();
    }
}
