package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.DanceClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DanceClassRepository extends MongoRepository<DanceClass, String> {
}
