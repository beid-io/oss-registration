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
class JsonBodyTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testSigninParams() throws Exception {
        val builder = MockMvcRequestBuilders
                .post("/signin")
                .header("Content-Type", "multipart/form-data")
                .param("username", "aa")
                .param("password", "aa");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assert "false".equals(body);
    }

    @Test
    void testSigninJson() throws Exception {
        val builder = MockMvcRequestBuilders
                .post("/signin")
                .header("Content-Type", "application/json")
                .content("{ \"username\" : \"aa\" ,\"password\" : \"bb\" }");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assert "true".equals(body);
    }

}