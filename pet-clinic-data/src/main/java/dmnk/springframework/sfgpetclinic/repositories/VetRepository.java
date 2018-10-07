package dmnk.springframework.sfgpetclinic.repositories;

import dmnk.springframework.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
