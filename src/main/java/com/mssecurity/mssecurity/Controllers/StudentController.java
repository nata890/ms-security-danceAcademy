package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.Student;
import com.mssecurity.mssecurity.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository theStudentRepository;

    // Método GET todos
    @GetMapping("")
    public List<Student> index() {
        return this.theStudentRepository.findAll();
    }

    // Método GET uno
    @GetMapping("{id}")
    public Student show(@PathVariable String id) {
        Student theStudent = this.theStudentRepository.findById(id).orElse(null);
        return theStudent;
    }

    // Método POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Student store(@RequestBody Student newStudent) {
        return this.theStudentRepository.save(newStudent);
    }

    // Método PUT
    @PutMapping("{id}")
    public Student update (@PathVariable String id, @RequestBody Student theNewStudent) {
        Student theActualStudent = this.theStudentRepository.findById(id).orElse(null);

        if (theActualStudent != null) {
            theActualStudent.setName(theNewStudent.getName());
            theActualStudent.setEmail(theNewStudent.getEmail());
            theActualStudent.setGender(theNewStudent.getGender());
            return this.theStudentRepository.save(theActualStudent);
        } else {
            return null;
        }
    }

    // Método DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(("{id}"))
    public void destroy(@PathVariable String id) {
        Student theStudent = this.theStudentRepository.findById(id).orElse(null);

        if (theStudent != null) {
            this.theStudentRepository.delete(theStudent);
        }
    }
}
