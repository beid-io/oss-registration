package io.beid.authorize;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessCRUD extends CrudRepository<Access, String> {

    Optional<Access> findByToken(final String token);

}
