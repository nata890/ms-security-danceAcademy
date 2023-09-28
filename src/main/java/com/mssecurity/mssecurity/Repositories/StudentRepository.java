package com.mssecurity.mssecurity.Repositories;

import com.mssecurity.mssecurity.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
