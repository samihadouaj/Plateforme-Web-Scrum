package com.backend.backend.Repository;

import com.backend.backend.Model.Epic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EpicRepository extends MongoRepository<Epic, Long> {
}
