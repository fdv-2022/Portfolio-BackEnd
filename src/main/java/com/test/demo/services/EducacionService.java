package com.test.demo.services;

import com.test.demo.model.Educacion;
import com.test.demo.repositories.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EducacionService {
    private final EducacionRepository educacionRepository;

    @Autowired
    public EducacionService(EducacionRepository educacionRepository){
        this.educacionRepository = educacionRepository;
    }

    public List<List<String>> getEducacion(){
        List<Educacion> educationList = educacionRepository.findAll();
        Iterator<Educacion> listIterator = educationList.iterator();
        List<List<String>> returnList = new ArrayList<List<String>>();
        while (listIterator.hasNext()){
            Educacion currentObject = listIterator.next();
            List<String> listItem = new ArrayList<String>();
            listItem.add(currentObject.getPlace());
            listItem.add(currentObject.getDurationString());
            returnList.add(listItem);
        }
        return returnList;
    }

    public void newEducacion(Educacion educacion){
        educacionRepository.save(educacion);
    }

    public void clearEducacion(){
        educacionRepository.deleteAll();
    }
}
