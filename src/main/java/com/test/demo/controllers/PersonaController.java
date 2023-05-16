package com.test.demo.controllers;

import com.test.demo.model.Persona;
import com.test.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/personas")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService){
        this.personaService = personaService;
    }
    @GetMapping("/safe")
    public List<String> getPersonas(){
        return personaService.getPersonas();
    }

    @PutMapping()
    public void registerPersona(@RequestBody List<String> personaData) {
        Persona personaToAdd = new Persona(1L, 1L , personaData.get(0),  personaData.get(1), personaData.get(2), personaData.get(3), personaData.get(4), personaData.get(5));
        personaService.savePersona(personaToAdd);
    }

    @PatchMapping("/aboutMe")
    public Persona patchAboutMe (@RequestBody List<String> personaData) {
       return personaService.patchAboutMe(personaData);
    }


    @PatchMapping("/banner")
    public Persona patchBanner (@RequestBody String bannerLink){
        return personaService.patchBanner(bannerLink);
    }

    @DeleteMapping()
    public void deleteSubtitleSection (){
        personaService.deleteSubtitleSection();
    }
}
