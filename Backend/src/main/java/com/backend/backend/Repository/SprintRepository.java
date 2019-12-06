package com.backend.backend.Repository;

import com.backend.backend.Model.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, Long> {
}
