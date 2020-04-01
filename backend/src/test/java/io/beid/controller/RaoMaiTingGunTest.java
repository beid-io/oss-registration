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
class RaoMaiTingGunTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testRegisterLight() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/register/light/5101600007236/Peerapat/Asoktummarungsri/20190101/ME0111111");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("body {}", body);
    }

    @Test
    void testRegisterRedis() throws Exception {
        val builder = MockMvcRequestBuilders
                .get("/register/redis/5101600007236/Peerapat/Asoktummarungsri/20190101/ME0111111");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("body {}", body);
    }

    @Test
    void testRegister() throws Exception {
        val builder = MockMvcRequestBuilders
                .post("/register")
                .header("Content-Type", "multipart/form-data")
                .param("citizenId", "5101600007236")
                .param("name", "Peerapat")
                .param("surName", "Asoktummarungsri")
                .param("dob", "20190101")
                .param("laserCode", "ME0111111")
                .param("income", "15000")
                .param("email", "aa")
                .param("mobileNo", "aa")
                .param("lineId", "aa")
                .param("receiveFrom", "0")
                .param("contactHomeno", "aa")
                .param("contactMoo", "aa")
                .param("contactBuilding", "aa")
                .param("contactSoi", "aa")
                .param("contactRoad", "aa")
                .param("contactZipcode", "aa")
                .param("contactTumbon", "aa")
                .param("contactBuilding", "aa")
                .param("contactAumphur", "aa")
                .param("contactCity", "aa")
                .param("docHomeno", "aa")
                .param("docMoo", "aa")
                .param("docBuilding", "aa")
                .param("docSoi", "aa")
                .param("docRoad", "aa")
                .param("docZipcode", "aa")
                .param("docTumbon", "aa")
                .param("docBuilding", "aa")
                .param("docAumphur", "aa")
                .param("docCity", "aa");

        val body = mvc.perform(builder)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        log.info("response {}", body);
        assert !body.isEmpty();
    }

}
