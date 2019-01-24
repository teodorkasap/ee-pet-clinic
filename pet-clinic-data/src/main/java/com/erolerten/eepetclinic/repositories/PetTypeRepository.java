package com.erolerten.eepetclinic.repositories;

import com.erolerten.eepetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
