package io.beid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
class Econsent {

    @PostMapping(value = "/econsent/submit")
    private String postParams(@RequestParam("random_uuid") final String postParm
            , @RequestParam("is_accept") final boolean is_accept) {
        return "OK";
    }

}
