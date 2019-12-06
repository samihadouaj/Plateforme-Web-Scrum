package com.backend.backend.Repository;

import com.backend.backend.Model.BacklogItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BacklogItemRepository extends MongoRepository<BacklogItem, Long> {
}
