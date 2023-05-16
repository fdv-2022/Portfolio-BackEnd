package com.test.demo.services;

import com.test.demo.model.Skills;
import com.test.demo.repositories.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SkillsService {
    private final SkillsRepository skillsRepository;

    @Autowired
    public SkillsService(SkillsRepository skillsRepository){
        this.skillsRepository = skillsRepository;
    }

    public List<List<String>> getSkills(){
        List<Skills> skillsList = skillsRepository.findAll();
        Iterator<Skills> listIterator = skillsList.iterator();
        List<List<String>> returnList = new ArrayList<List<String>>();
        while (listIterator.hasNext()){
            Skills currentElement = listIterator.next();
            List<String> listElement = new ArrayList<String>();
            listElement.add(currentElement.getSkill());
            listElement.add(currentElement.getPercentageString());
            returnList.add(listElement);
        }
        return returnList;
    }

    public void newSkill(Skills skill){
        skillsRepository.save(skill);
    }

    public void skillsClear(){
        skillsRepository.deleteAll();
    }
}
