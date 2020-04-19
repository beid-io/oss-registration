package io.beid.controller;

import io.beid.module.account.AccountFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class Account {

    @Autowired
    private AccountFacade facade;

    @PostMapping(value = "/account/save")
    private String postParams(@RequestParam("random_uuid") final String uuid
    , @RequestParam("citizen_id") final String cid) {
        return facade.save(uuid);
    }

}
