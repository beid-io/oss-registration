package io.beid.module.account;

import io.beid.module.econsent.ConsentJDBC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class AccountFacade {

    private ConsentJDBC jdbc;

    @Transactional
    public String save(final String uuid) {
        val consent = jdbc.findById(uuid);
        if (consent.isEmpty())
            return "nok";

        if (consent.map(e -> !e.isAccept).get())
            return "nok";

        return "ok";
    }


}