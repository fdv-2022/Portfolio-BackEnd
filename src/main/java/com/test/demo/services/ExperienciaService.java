package com.test.demo.services;

import com.test.demo.model.Experiencia;
import com.test.demo.repositories.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExperienciaService {

    private final ExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(ExperienciaRepository experienciaRepository){
        this.experienciaRepository = experienciaRepository;
    }

    public List<List<String>> getExperiencia() {
        List<Experiencia> experienciaList = experienciaRepository.findAll();
        Iterator<Experiencia> listIterator = experienciaList.iterator();
        List<List<String>> returnList = new ArrayList<List<String>>();
        while (listIterator.hasNext()){
            Experiencia currentElement = listIterator.next();
            List<String> listElement = new ArrayList<String>();
            listElement.add(currentElement.getPlace());
            listElement.add(currentElement.getDurationString());
            returnList.add(listElement);
        }
        return returnList;
    }

    public void newExperiencia(Experiencia experiencia) {
        experienciaRepository.save(experiencia);
    }

    public void experenciaClear(){
        experienciaRepository.deleteAll();
    }
}
