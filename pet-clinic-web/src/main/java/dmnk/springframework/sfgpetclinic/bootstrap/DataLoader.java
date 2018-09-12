package dmnk.springframework.sfgpetclinic.bootstrap;

import dmnk.springframework.sfgpetclinic.model.Owner;
import dmnk.springframework.sfgpetclinic.model.Vet;
import dmnk.springframework.sfgpetclinic.services.OwnerService;
import dmnk.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michal");
        owner1.setLastName("Michalowski");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Robert");
        owner2.setLastName("Nowak");
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Aleksander");
        vet1.setLastName("Kowalski");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jan");
        vet2.setLastName("Ptak");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
