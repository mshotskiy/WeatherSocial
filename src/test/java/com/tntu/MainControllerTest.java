package com.tntu;

import com.tntu.controller.WeatherController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("mshotskiy")
public class MainControllerTest {
    @Autowired
    private WeatherController weatherController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mainPageTest() throws Exception{
        this.mockMvc.perform(get("/weather"))
                .andDo(print())
                .andExpect(authenticated());
    }
}
