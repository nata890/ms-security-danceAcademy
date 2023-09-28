package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.Academy;
import com.mssecurity.mssecurity.Models.Instructor;
import com.mssecurity.mssecurity.Repositories.AcademyRepository;
import com.mssecurity.mssecurity.Repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorRepository theInstructorRepository;

    @Autowired
    private AcademyRepository theAcademyRepository;

    //metodo para listar
    @GetMapping("")
    public List<Instructor> index(){
        return this.theInstructorRepository.findAll();
    }

    //metodo para almacenar
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Instructor store(@RequestBody Instructor newInstructor){
        return this.theInstructorRepository.save(newInstructor);
    }

    //metodo para ver uno
    @GetMapping("{id}")
    public Instructor show(@PathVariable String id){
        Instructor theInstructor=this.theInstructorRepository
                .findById(id)
                .orElse(null);
        return theInstructor;
    }

    //metodo para la actualizacion
    @PutMapping("{id}")
    public Instructor update(@PathVariable String id,@RequestBody Instructor theNewInstructor){
        Instructor theActualInstructor=this.theInstructorRepository
                .findById(id)
                .orElse(null);
        if (theActualInstructor!=null){
            theActualInstructor.setName(theNewInstructor.getName());
            theActualInstructor.setEmail(theNewInstructor.getEmail());
            theActualInstructor.setSalary(theNewInstructor.getSalary());
            return this.theInstructorRepository.save(theActualInstructor);
        }else{
            return null;
        }
    }

    //metodo de eliminacion
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void destroy(@PathVariable String id){
        Instructor theInstructor=this.theInstructorRepository
                .findById(id)
                .orElse(null);
        if (theInstructor!=null){
            this.theInstructorRepository.delete(theInstructor);
        }
    }

    //Agregar una academia a un instructor
    @PutMapping ("{instructor_id}/academy/{academy_id}")
    public Instructor matchInstructorAcademy(@PathVariable String instructor_id, @PathVariable String academy_id){
        Instructor theActualInstructor=this.theInstructorRepository
                .findById(instructor_id)
                .orElse(null);
        Academy theActualAcademy= this.theAcademyRepository
                .findById(academy_id)
                .orElse(null);

        if (theActualInstructor!=null && theActualAcademy!= null){
            theActualInstructor.setAcademy(theActualAcademy);
            return this.theInstructorRepository.save(theActualInstructor);
        }else{
            return null;
        }
    }

    //Desasociar una academia de un instructor
    @PutMapping ("{instructor_id}/academy")
    public Instructor unMatchInstructorAcademy(@PathVariable String instructor_id){
        Instructor theActualInstructor=this.theInstructorRepository
                .findById(instructor_id)
                .orElse(null);

        if (theActualInstructor!=null ){
            theActualInstructor.setAcademy(null);
            return this.theInstructorRepository.save(theActualInstructor);
        }else{
            return null;
        }
    }
}
