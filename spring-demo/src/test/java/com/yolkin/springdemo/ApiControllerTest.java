package com.yolkin.springdemo;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.03.18)
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VisitsRepository visitsRepository;

    @Before
    public void setUp() throws Exception {
        visitsRepository.deleteAll();
    }

    @Test
    public void testIndex() throws Exception {
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Spring")));
    }

    @Test
    public void apiControllerShouldReturnVisits() throws Exception {
        //save some records in H2 DB
        mockMvc.perform(get("/"));

        // we should get one record in visits
        mockMvc.perform(get("/api/visits"))
                .andExpect(jsonPath("$.*.description", iterableWithSize(1)));
    }
}
