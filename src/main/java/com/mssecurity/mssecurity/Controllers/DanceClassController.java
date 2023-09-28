package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.DanceClass;
import com.mssecurity.mssecurity.Repositories.DanceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/danceClass")
public class DanceClassController {

    @Autowired
    private DanceClassRepository theDanceClassRepository;

    // Método GET todos
    @GetMapping("")
    public List<DanceClass> index() {
        return this.theDanceClassRepository.findAll();
    }

    // Método GET uno
    @GetMapping("{id}")
    public DanceClass show(@PathVariable String id) {
        DanceClass theDanceClass = this.theDanceClassRepository.findById(id).orElse(null);
        return theDanceClass;
    }

    // Método POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DanceClass store(@RequestBody DanceClass newDanceClass) {
        return this.theDanceClassRepository.save(newDanceClass);
    }

    // Método PUT
    @PutMapping("{id}")
    public DanceClass update (@PathVariable String id, @RequestBody DanceClass theNewDanceClass) {
        DanceClass theActualDanceClass = this.theDanceClassRepository.findById(id).orElse(null);

        if (theActualDanceClass != null) {
            theActualDanceClass.setDifficulty(theNewDanceClass.getDifficulty());
            theActualDanceClass.setDuration(theNewDanceClass.getDuration());
            return this.theDanceClassRepository.save(theActualDanceClass);
        } else {
            return null;
        }
    }

    // Método DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(("{id}"))
    public void destroy(@PathVariable String id) {
        DanceClass theDanceClass = this.theDanceClassRepository.findById(id).orElse(null);

        if (theDanceClass != null) {
            this.theDanceClassRepository.delete(theDanceClass);
        }
    }
}
