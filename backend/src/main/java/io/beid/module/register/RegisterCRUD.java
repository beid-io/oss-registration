package io.beid.module.register;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterCRUD extends CrudRepository<RegisterEntity, String> {

}
