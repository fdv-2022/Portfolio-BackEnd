package com.test.demo.controllers;

import com.test.demo.model.Proyecto;
import com.test.demo.services.ProyectoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/v1/proyectos")
public class ProyectoController {
    private final ProyectoSerivce proyectoService;
    @Autowired
    public ProyectoController(ProyectoSerivce proyectoSerivce){
        this.proyectoService = proyectoSerivce;
    }

    @GetMapping("/safe")
    public List<List<String>> getProyectos(){
        return proyectoService.getProyectos();
    }

    @PutMapping()
    public void registerProyect(@RequestBody List<List<String>> proyectoList){
        proyectoService.proyectoClear();
        Iterator<List<String>> listIterator = proyectoList.iterator();
        Long idCounter = 1L;
        while (listIterator.hasNext()){
            List<String> currentElement = listIterator.next();
            Proyecto proyectoToAdd = new Proyecto(idCounter,1L, currentElement.get(0), currentElement.get(1), currentElement.get(2), currentElement.get(3) );
            proyectoService.newProyecto(proyectoToAdd);
            idCounter++;
        }
    }

    @PutMapping("/{id}")
    public Proyecto updateProject(@PathVariable Long id, @RequestBody List<String> proyectData){
        return proyectoService.updateProyecto(proyectData, id);
    }

    @DeleteMapping("/{id}")
    public void projectDelete(@PathVariable Long id){
        proyectoService.projectDelete(id);
    }
}
