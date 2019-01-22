package com.erolerten.eepetclinic.services.map;

import com.erolerten.eepetclinic.model.Owner;
import com.erolerten.eepetclinic.model.Pet;
import com.erolerten.eepetclinic.services.OwnerService;
import com.erolerten.eepetclinic.services.PetService;
import com.erolerten.eepetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;


    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                        if(pet.getId()==null){
                            Pet savedPet=petService.save(pet);
                            pet.setId(savedPet.getId());
                        }

                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }


    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
