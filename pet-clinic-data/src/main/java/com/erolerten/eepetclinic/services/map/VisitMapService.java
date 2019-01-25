package com.erolerten.eepetclinic.services.map;


import com.erolerten.eepetclinic.model.Visit;
import com.erolerten.eepetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getOwner()==null|| visit.getPet().getId()==null){
            throw new RuntimeException("Properties are missing, invalid visit...");
        }
            return super.save(visit);
    }

    @Override
    public void delete(Visit object) {
            super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
            super.deleteById(id);
    }
}