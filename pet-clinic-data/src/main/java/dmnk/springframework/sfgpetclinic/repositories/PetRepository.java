package dmnk.springframework.sfgpetclinic.repositories;

import dmnk.springframework.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
