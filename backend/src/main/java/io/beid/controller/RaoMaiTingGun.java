package io.beid.controller;

import io.beid.module.register.RegisterFacade;
import io.beid.module.register.RegisterForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class RaoMaiTingGun {

    private final RegisterFacade facade;

    @PostMapping(value = "/register")
    private String postParams(final RegisterForm form) {

        return facade.save(form);
    }

    @PostMapping(value = "/register")
    private String postJson(@RequestBody final String json) {

        return "";
    }

}
