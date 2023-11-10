package com.fastcampus.board.Controller;

import com.fastcampus.board.controller.MainController;
import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

    private final MockMvc mvc;

    public MainControllerTest(@Autowired MockMvc mvc){
        this.mvc = mvc;
    }

    @Disabled
    @Test
    void  givenNothing_whenRequestingRootPage_thenRedirectsToArticlesPAge() throws Exception {
        //Given

        //When
        mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());
        //Then

    }

}