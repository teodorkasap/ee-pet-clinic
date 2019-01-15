package com.erolerten.eepetclinic.services;

import com.erolerten.eepetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByID(Long id);

    Vet save(Vet owner);

    Set<Vet> findAll();
}
