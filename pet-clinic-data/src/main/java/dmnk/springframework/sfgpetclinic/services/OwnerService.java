package dmnk.springframework.sfgpetclinic.services;

import dmnk.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
