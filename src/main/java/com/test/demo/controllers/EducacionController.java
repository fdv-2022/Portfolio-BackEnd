package com.test.demo.controllers;

import com.test.demo.model.Educacion;
import com.test.demo.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping(path= "api/v1/educacion")
public class EducacionController {
    private final EducacionService educacionService;

    @Autowired
    public EducacionController(EducacionService educacionService){
        this.educacionService = educacionService;
    }

    @GetMapping("/safe")
    public List<List<String>> getEducacion(){
        return educacionService.getEducacion();
    }

    @PutMapping()
    public void newEducacion(@RequestBody List<List <String>> educacionList){
        educacionService.clearEducacion();
        Iterator<List<String>> listIterator = educacionList.iterator();
        Long idCounter = 1L;
        while (listIterator.hasNext()){
            List<String> currentElement = listIterator.next();
            Educacion educacionToAdd = new Educacion(idCounter, 1L, currentElement.get(0),currentElement.get(1));
            educacionService.newEducacion(educacionToAdd);
            idCounter++;
        }
    }

    @DeleteMapping()
    public void dataDelete(){
        educacionService.clearEducacion();
    }
}
