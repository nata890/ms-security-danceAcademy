package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.DanceClass;
import com.mssecurity.mssecurity.Models.DanceClassStyle;
import com.mssecurity.mssecurity.Models.Style;
import com.mssecurity.mssecurity.Repositories.DanceClassRepository;
import com.mssecurity.mssecurity.Repositories.DanceClassStyleRepository;
import com.mssecurity.mssecurity.Repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/danceClassStyle")
public class DanceClassStyleController {
    @Autowired
    private DanceClassStyleRepository theDanceClassStyleRepository;

    @Autowired
    private DanceClassRepository theDanceClassRepository;

    @Autowired
    private StyleRepository theStyleRepository;

    // Método POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("danceClass/{danceClass_id}/style/{style_id}")
    public DanceClassStyle store(@PathVariable String danceClass_id,
                            @PathVariable String style_id) {
        DanceClass theDanceClass=theDanceClassRepository.findById(danceClass_id).orElse(null);
        Style theStyle=theStyleRepository.findById(style_id).orElse(null);
        if(theDanceClass!=null && theStyle!=null){
            DanceClassStyle newDanceClassStyle = new DanceClassStyle();
            newDanceClassStyle.setDanceClass(theDanceClass);
            newDanceClassStyle.setStyle(theStyle);
            return this.theDanceClassStyleRepository.save(newDanceClassStyle);
        } else {
            return null;
        }
    }

    // Método GET (TODOS)
    @GetMapping("")
    public List<DanceClassStyle> index(){
        return this.theDanceClassStyleRepository.findAll();
    }

    // Método DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void destroy(@PathVariable String id) {
        DanceClassStyle theDanceClassStyle = this.theDanceClassStyleRepository
                .findById(id)
                .orElse(null);
        if (theDanceClassStyle != null) {
            this.theDanceClassStyleRepository.delete(theDanceClassStyle);
        }
    }

}
