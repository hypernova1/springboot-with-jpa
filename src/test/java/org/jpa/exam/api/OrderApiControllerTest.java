package org.jpa.exam.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class OrderApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getEntity() throws Exception {
        mockMvc.perform(get("/api/v1/orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getDto() throws Exception {
        mockMvc.perform(get("/api/v2/orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getFetchDto() throws Exception {
        mockMvc.perform(get("/api/v3/orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getFetchDto3_1() throws Exception {
        mockMvc.perform(get("/api/v3.1/orders?offset=0&limit=10"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void getDtoV4() throws Exception {
        mockMvc.perform(get("/api/v4/orders"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(2)));
    }

}