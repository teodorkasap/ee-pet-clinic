package com.erolerten.eepetclinic.services;

import com.erolerten.eepetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByID(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
