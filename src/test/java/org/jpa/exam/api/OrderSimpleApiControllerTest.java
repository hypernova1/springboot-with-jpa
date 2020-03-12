package org.jpa.exam.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class OrderSimpleApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getEntity() throws Exception {
        mockMvc.perform(get("/api/v1/simple-orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getDto() throws Exception {
        mockMvc.perform(get("/api/v2/simple-orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getFetchJoin() throws Exception {
        mockMvc.perform(get("/api/v3/simple-orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}