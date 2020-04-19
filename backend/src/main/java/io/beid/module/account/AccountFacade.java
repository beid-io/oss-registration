package io.beid.module.account;

import io.beid.module.econsent.ConsentJDBC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountFacade {

    @Autowired
    private ConsentJDBC consent;

    @Autowired
    private AccountJDBC account;

    @Transactional
    public String save(final String uuid, final String jsonData) {
        val econsent = consent.findById(uuid);
        if (econsent.isEmpty())
            return "nok";

        if (econsent.map(e -> !e.isAccept).get())
            return "nok";

        val entity = new AccountEntity(
                uuid
                , jsonData
                , new Timestamp(System.currentTimeMillis())
                , false);
        account.save(entity);

        return "ok";
    }

    @Transactional
    public String optout(final String uuid) {
        val econsent = consent.findById(uuid);
        econsent.ifPresent(e -> {
            e.setIsAccept(false);
            consent.save(e);
            account.deleteById(uuid);
        });

        return "ok";
    }

    public String find(final String uuid) {
        val data = account.findById(uuid);

        return data.map(e -> e.jsonData).orElse("{}");
    }

}