package com.test.demo.controllers;

import com.test.demo.model.Skills;
import com.test.demo.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/skills")
public class SkillsControlller {
    private final SkillsService skillsService;

    @Autowired
    public SkillsControlller(SkillsService skillsService){
        this.skillsService = skillsService;
    }

    @GetMapping("/safe")
    public List<List<String>> getSkills(){
       return skillsService.getSkills();
    }

    @PutMapping()
    public void registerSkill(@RequestBody List<List<String>> skillList){
        skillsService.skillsClear();
        Iterator<List<String>> listIterator = skillList.iterator();
        Long idCounter = 1L;
        while (listIterator.hasNext()){
            List<String> currentElement = listIterator.next();
            Skills skillToAdd = new Skills(idCounter,1L, currentElement.get(0), currentElement.get(1));
            skillsService.newSkill(skillToAdd);
            idCounter++;
        }
    }

    @DeleteMapping()
    public void dataDelete(){
        skillsService.skillsClear();
    }
}
