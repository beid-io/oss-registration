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
class HelloTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testHi() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/hi");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assert "Yo !".equals(body);
    }

    @Test
    void testEcho() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/echo/man");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assert "man".equals(body);
    }

}