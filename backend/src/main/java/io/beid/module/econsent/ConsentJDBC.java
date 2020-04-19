package io.beid.module.econsent;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsentJDBC extends CrudRepository<ConsentEntity, String> {

}
