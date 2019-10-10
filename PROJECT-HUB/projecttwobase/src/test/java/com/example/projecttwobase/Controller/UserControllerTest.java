package com.example.projecttwobase.Controller;

import com.example.projecttwobase.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)

public class UserControllerTest {
    /**Main entry point for server-side Spring MVC test support.**/
    @Autowired
    private MockMvc mockMvc;
}
