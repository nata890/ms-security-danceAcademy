package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.DanceClass;
import com.mssecurity.mssecurity.Models.Student;
import com.mssecurity.mssecurity.Models.StudentDanceClass;
import com.mssecurity.mssecurity.Repositories.DanceClassRepository;
import com.mssecurity.mssecurity.Repositories.StudentDanceClassRepository;
import com.mssecurity.mssecurity.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/studentDanceClass")
public class StudentDanceClassController {

    @Autowired
    private StudentDanceClassRepository theStudentDanceClassRepository;

    @Autowired
    private StudentRepository theStudentRepository;

    @Autowired
    private DanceClassRepository theDanceClassRepository;

    @GetMapping("")
    public List<StudentDanceClass> index(){
        return this.theStudentDanceClassRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("student/{student_id}/danceClass/{danceClass_id}")
    public StudentDanceClass store(@PathVariable String student_id, @PathVariable String danceClass_id){
        Student theStudent=this.theStudentRepository.findById(student_id).orElse(null);
        DanceClass theDanceClass=this.theDanceClassRepository.findById(danceClass_id).orElse(null);

        if(theStudent!= null && theDanceClass!= null){
            StudentDanceClass newStudentDanceClass=new StudentDanceClass();
            newStudentDanceClass.setStudent(theStudent);
            newStudentDanceClass.setDanceClass(theDanceClass);
            return this.theStudentDanceClassRepository.save(newStudentDanceClass);
        } else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void destroy(@PathVariable String id){
        StudentDanceClass theStudentDanceClass=this.theStudentDanceClassRepository
                .findById(id)
                .orElse(null);
        if (theStudentDanceClass!=null){
            this.theStudentDanceClassRepository.delete(theStudentDanceClass);
        }
    }
}
