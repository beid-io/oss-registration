package io.beid.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class AMTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testVerifyAPP_DEMO_1_N() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/verify/APP-DEMO-1-N");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("body {}", body);
        assert "API".equals(body) : "body should be API";

    }

}