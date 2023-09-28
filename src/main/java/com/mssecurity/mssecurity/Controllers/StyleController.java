package com.mssecurity.mssecurity.Controllers;

import com.mssecurity.mssecurity.Models.Style;
import com.mssecurity.mssecurity.Repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/style")
public class StyleController {

    @Autowired
    private StyleRepository theStyleRepository;

    //metodo para listar
    @GetMapping("")
    public List<Style> index(){
        return this.theStyleRepository.findAll();
    }

    //metodo para almacenar
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Style store(@RequestBody Style newStyle){
        return this.theStyleRepository.save(newStyle);
    }

    //metodo para ver uno
    @GetMapping("{id}")
    public Style show(@PathVariable String id){
        Style theStyle=this.theStyleRepository
                .findById(id)
                .orElse(null);
        return theStyle;
    }

    //metodo para la actualizacion
    @PutMapping("{id}")
    public Style update(@PathVariable String id,@RequestBody Style theNewStyle){
        Style theActualStyle=this.theStyleRepository
                .findById(id)
                .orElse(null);
        if (theActualStyle!=null){
            theActualStyle.setName(theNewStyle.getName());
            theActualStyle.setGenre(theNewStyle.getGenre());
            theActualStyle.setDescription(theNewStyle.getDescription());
            return this.theStyleRepository.save(theActualStyle);
        }else{
            return null;
        }
    }

    //metodo de eliminacion
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void destroy(@PathVariable String id){
        Style theStyle=this.theStyleRepository
                .findById(id)
                .orElse(null);
        if (theStyle!=null){
            this.theStyleRepository.delete(theStyle);
        }
    }
}
