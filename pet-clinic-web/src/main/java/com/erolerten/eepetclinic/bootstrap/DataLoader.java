package com.erolerten.eepetclinic.bootstrap;

import com.erolerten.eepetclinic.model.Owner;
import com.erolerten.eepetclinic.model.Vet;
import com.erolerten.eepetclinic.services.OwnerService;
import com.erolerten.eepetclinic.services.VetService;
import com.erolerten.eepetclinic.services.map.OwnerServiceMap;
import com.erolerten.eepetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerServıce;
    private final VetService vetService;


    public DataLoader() {
        ownerServıce = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerServıce.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Fona");
        owner2.setLastName("Glenanne");

        ownerServıce.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1=new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2=new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");


    }
}
