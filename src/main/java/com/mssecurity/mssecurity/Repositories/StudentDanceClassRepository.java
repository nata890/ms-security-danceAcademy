package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.StudentDanceClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentDanceClassRepository extends MongoRepository<StudentDanceClass, String> {
}
