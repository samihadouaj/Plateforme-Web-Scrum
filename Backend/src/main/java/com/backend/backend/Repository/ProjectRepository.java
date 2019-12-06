package com.backend.backend.Repository;

import com.backend.backend.Model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, Long> {
}
