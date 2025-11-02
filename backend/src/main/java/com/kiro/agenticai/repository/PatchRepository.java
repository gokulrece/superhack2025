package com.kiro.agenticai.repository;

import com.kiro.agenticai.model.Patch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatchRepository extends MongoRepository<Patch, String> {
}
