package com.justtip.backend.repo;

import com.justtip.backend.models.OtherItem;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<OtherItem,String> {
}
