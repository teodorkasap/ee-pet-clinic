package com.erolerten.eepetclinic.services;

import com.erolerten.eepetclinic.model.Owner;

import java.util.Set;

public interface OwnerServices {

    Owner findByLastName(String lastName);

    Owner findByID(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
