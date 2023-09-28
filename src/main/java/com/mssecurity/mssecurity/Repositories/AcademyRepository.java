package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.Academy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcademyRepository extends MongoRepository<Academy, String> {
}
