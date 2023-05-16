package com.test.demo.controllers;

import com.test.demo.model.Experiencia;
import com.test.demo.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/experiencia")
public class ExperienciaController {

    private final ExperienciaService experienciaService;

    @Autowired
    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping("/safe")
    public List<List<String>> getExperiencia() {
         return experienciaService.getExperiencia();
    }

    @PutMapping()
    public void newExperiencia(@RequestBody List<List<String>> experienciaList){
        experienciaService.experenciaClear();
        Iterator<List<String>> listIterator = experienciaList.iterator();
        Long idCounter = 1L;
        while (listIterator.hasNext()) {
            List<String> currentElement = listIterator.next();
            Experiencia experienciaToAdd = new Experiencia( idCounter,1L, currentElement.get(0), currentElement.get(1));
            experienciaService.newExperiencia(experienciaToAdd);
            idCounter++;
        }
    }

    @DeleteMapping()
    public void dataDelete(){
        experienciaService.experenciaClear();
    }
}
