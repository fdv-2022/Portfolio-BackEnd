package com.test.demo.services;

import com.test.demo.model.Proyecto;
import com.test.demo.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoSerivce {
    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoSerivce(ProyectoRepository proyectoRepository){
        this.proyectoRepository = proyectoRepository;
    }

    public List<List<String>> getProyectos(){
        List<Proyecto> proyectoList = proyectoRepository.findAll();
        Iterator<Proyecto> listIterator = proyectoList.iterator();
        List<List<String>> returnList = new ArrayList<List<String>>();
        while(listIterator.hasNext()){
            Proyecto currentElement = listIterator.next();
            List<String> listElement = new ArrayList<String>();
            listElement.add(currentElement.getImageLink());
            listElement.add(currentElement.getTitle());
            listElement.add(currentElement.getDescription());
            listElement.add(currentElement.getProyectLink());
            listElement.add(currentElement.getId().toString());
            returnList.add(listElement);
        }
        return returnList;
    }

    public void newProyecto(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }

    public void proyectoClear(){
        proyectoRepository.deleteAll();
    }

    public Proyecto updateProyecto(List<String> proyectoData, Long id){
        Proyecto proyectoUpdated = proyectoRepository.findById(id).get();
        proyectoUpdated.setImageLink(proyectoData.get(0));
        proyectoUpdated.setTitle(proyectoData.get(1));
        proyectoUpdated.setDescription(proyectoData.get(2));
        proyectoUpdated.setProyectLink(proyectoData.get(3));
        proyectoRepository.save(proyectoUpdated);
        return proyectoUpdated;
    }

    public void projectDelete(Long id){
        proyectoRepository.deleteById(id);
    }
}
