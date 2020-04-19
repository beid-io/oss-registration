package io.beid.module.econsent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsentFacade {

    @Autowired
    private ConsentJDBC jdbc;

    @Transactional
    public String save(final String uuid, final Boolean isAccept) {
        log.info("UUID {}, accept = {}", uuid, isAccept);

        val entity = new ConsentEntity(
                uuid
                , isAccept
                , new Timestamp(System.currentTimeMillis())
                , false);

        jdbc.save(entity);

        return (isAccept) ? "ok" : "nok";
    }

}