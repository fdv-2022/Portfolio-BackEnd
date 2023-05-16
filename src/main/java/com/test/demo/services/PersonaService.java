package com.test.demo.services;

import com.test.demo.model.Persona;
import com.test.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    public List<String> getPersonas(){
        List<Persona> PersonalData = personaRepository.findAll();
        List<String> returnData = new ArrayList<String>();
        Persona data = PersonalData.get(0);
        returnData.add(data.getName());
        returnData.add(data.getDomicilio());
        returnData.add(data.getSubtitle());
        returnData.add(data.getSubtitleData());
        returnData.add(data.getPictureLink());
        returnData.add(data.getBannerLink());
        return returnData;
    }

    public void savePersona(Persona persona) {
        personaRepository.deleteAll();
        personaRepository.save(persona);
    }

    public Persona patchAboutMe(List<String> personaData) {
        Persona personaPatched = personaRepository.findById(1L).get();
        personaPatched.setName(personaData.get(0));
        personaPatched.setDomicilio(personaData.get(1));
        personaPatched.setSubtitle(personaData.get(2));
        personaPatched.setSubtitleData(personaData.get(3));
        personaPatched.setPictureLink(personaData.get(4));
        personaRepository.save(personaPatched);
        return personaPatched;
    }

    public Persona patchBanner(String bannerLink) {
        Persona personaPatched = personaRepository.findById(1L).get();
        personaPatched.setBannerLink(bannerLink);
        personaRepository.save(personaPatched);
        return personaPatched;
    }

    public void deleteSubtitleSection() {
        Persona personaPatched = personaRepository.findById(1L).get();
        personaPatched.setSubtitle("");
        personaPatched.setSubtitleData("");
        personaRepository.save(personaPatched);
    }
}
