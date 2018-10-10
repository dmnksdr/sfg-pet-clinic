package dmnk.springframework.sfgpetclinic.bootstrap;

import dmnk.springframework.sfgpetclinic.model.*;
import dmnk.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

//        Owner owner1 = new Owner();
//        owner1.setFirstName("Michal");
//        owner1.setLastName("Michalowski");
//        owner1.setAddress("Bobrzyńskiego 123");
//        owner1.setCity("Poznań");
//        owner1.setTelephone("123123123");

        Owner owner1 = Owner.builder().firstName("Michal").lastName("Michalowski").address("Bobrzyńskiego 123").city("Poznań").telephone("123123123").build();

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

        Visit catVisit = new Visit();
        catVisit.setPet(annasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Aleksander");
        vet1.setLastName("Kowalski");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jan");
        vet2.setLastName("Ptak");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets");
    }
}
