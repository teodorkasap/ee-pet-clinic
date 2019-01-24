package com.erolerten.eepetclinic.repositories;

import com.erolerten.eepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
