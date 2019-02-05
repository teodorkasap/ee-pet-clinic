package com.erolerten.eepetclinic.services;

import com.erolerten.eepetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner,Long > {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);

}
