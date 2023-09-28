package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
}
