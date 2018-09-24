package dmnk.springframework.sfgpetclinic.bootstrap;

import dmnk.springframework.sfgpetclinic.model.Owner;
import dmnk.springframework.sfgpetclinic.model.Pet;
import dmnk.springframework.sfgpetclinic.model.PetType;
import dmnk.springframework.sfgpetclinic.model.Vet;
import dmnk.springframework.sfgpetclinic.services.OwnerService;
import dmnk.springframework.sfgpetclinic.services.PetTypeService;
import dmnk.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michal");
        owner1.setLastName("Michalowski");
        owner1.setAddress("Bobrzyńskiego 123");
        owner1.setCity("Poznań");
        owner1.setTelephone("123123123");

        Pet michalPet = new Pet();
        michalPet.setPetType(savedDogPetType);
        michalPet.setOwner(owner1);
        michalPet.setBirthDate(LocalDate.now());
        michalPet.setName("Fafik");

        owner1.getPets().add(michalPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Nowak");
        owner2.setAddress("Bobrzyńskiego 987");
        owner2.setCity("Wrocław");
        owner2.setTelephone("333444555");

        Pet annasPet = new Pet();
        annasPet.setPetType(savedCatPetType);
        annasPet.setOwner(owner2);
        annasPet.setBirthDate(LocalDate.now());
        annasPet.setName("Łiskas");

        owner2.getPets().add(annasPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Aleksander");
        vet1.setLastName("Kowalski");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jan");
        vet2.setLastName("Ptak");
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
