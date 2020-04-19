package io.beid.controller;

import io.beid.module.econsent.ConsentFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class Econsent {

    private ConsentFacade facade;

    @PostMapping(value = "/econsent/submit")
    private String postParams(@RequestParam("random_uuid") final String uuid
            , @RequestParam("is_accept") final boolean isAccept) {
        return facade.save(uuid, isAccept);
    }

}
