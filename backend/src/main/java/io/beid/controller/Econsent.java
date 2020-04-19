package io.beid.controller;

import io.beid.module.econsent.ConsentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class Econsent {

    @Autowired
    private ConsentFacade facade;

    @PostMapping(value = "/econsent/submit")
    private String submit(@RequestParam("random_uuid") final String uuid
            , @RequestParam("is_accept") final boolean isAccept) {
        val result = handle(uuid, isAccept);
        log.info("UUID:{}, isAccept:{} -> result:{}", uuid, isAccept, result);

        return result;
    }

    private String handle(final String uuid, final boolean isAccept) {
        try {
            return facade.save(uuid, isAccept);
        } catch (final Exception e) {
            log.error(e.getMessage(), e);
            return "Err";
        }
    }

}
