package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.Style;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StyleRepository extends MongoRepository<Style, String> {
}
