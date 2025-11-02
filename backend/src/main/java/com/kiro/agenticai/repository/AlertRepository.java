// AlertRepository.java
package com.kiro.agenticai.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.kiro.agenticai.model.Alert;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends MongoRepository<Alert, String> {}
