package com.justtip.backend.services;

import com.justtip.backend.models.OtherItem;
import com.justtip.backend.repo.ItemRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    public OtherItem getItemForId(String id){
        return itemRepo.findById(id).orElseThrow(RuntimeException::new);
    }
}
