package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.Academy;
import com.mssecurity.mssecurity.Repositories.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/academy")

public class AcademyController {

    @Autowired
    private AcademyRepository theAcademyRepository;

    @GetMapping("")
    public List<Academy> index(){
        return this.theAcademyRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Academy store(@RequestBody Academy newAcademy){
        return this.theAcademyRepository.save(newAcademy);
    }

    @GetMapping("{id}")
    public Academy show(@PathVariable String id){
        Academy theAcademy=this.theAcademyRepository
                .findById(id)
                .orElse(null);
        return theAcademy;
    }

    @PutMapping("{id}")
    public Academy update(@PathVariable String id,@RequestBody Academy theNewAcademy){
        Academy theActualAcademy=this.theAcademyRepository
                .findById(id)
                .orElse(null);
        if (theActualAcademy!=null){
            theActualAcademy.setName(theNewAcademy.getName());
            theActualAcademy.setAddress(theNewAcademy.getAddress());
            theActualAcademy.setTelephone(theNewAcademy.getTelephone());
            return this.theAcademyRepository.save(theActualAcademy);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void destroy(@PathVariable String id){
        Academy theAcademy=this.theAcademyRepository
                .findById(id)
                .orElse(null);
        if (theAcademy!=null){
            this.theAcademyRepository.delete(theAcademy);
        }
    }

}
