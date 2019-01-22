package com.erolerten.eepetclinic.bootstrap;

import com.erolerten.eepetclinic.model.Owner;
import com.erolerten.eepetclinic.model.Pet;
import com.erolerten.eepetclinic.model.PetType;
import com.erolerten.eepetclinic.model.Vet;
import com.erolerten.eepetclinic.services.OwnerService;
import com.erolerten.eepetclinic.services.PetTypeService;
import com.erolerten.eepetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//import com.erolerten.eepetclinic.services.map.OwnerServiceMap;
//import com.erolerten.eepetclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService= vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog=new PetType();
        dog.setName("Dog");
        PetType savedDogPetType=petTypeService.save(dog);

        PetType cat=new PetType();
        cat.setName("Cat");
        PetType savedCatPetType=petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 cumhuriyet cad.");
        owner1.setCity("istanbul");
        owner1.setTelephone("1234567899");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 meşrutiyet cad.");
        owner2.setCity("istanbul");
        owner2.setTelephone("6789912345");

        ownerService.save(owner2);

        Pet mikesPet=new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        Pet fionasCat=new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        System.out.println("Loaded Owners....");

        Vet vet1=new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
