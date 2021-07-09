package com.justtip.backend.controllers;

import com.justtip.backend.models.OtherItem;
import com.justtip.backend.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/item/{id}")
    public OtherItem getItemById(@PathVariable String id){
        return itemService.getItemForId(id);
    }
}
