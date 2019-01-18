package com.erolerten.eepetclinic.services;

import com.erolerten.eepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner,Long > {

    Owner findByLastName(String lastName);



}
