package io.beid.module.account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJDBC extends CrudRepository<AccountEntity, String> {

}
