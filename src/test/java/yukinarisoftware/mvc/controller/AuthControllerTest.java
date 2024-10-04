package yukinarisoftware.mvc.controller;

import jakarta.servlet.http.Cookie;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loginTest() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("username", "yuki")
                .param("password", "root")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpectAll(status().isOk(), content().string(Matchers.containsString("ok")));
    }

    @Test
    void loginTestFailed() throws Exception {
        mockMvc.perform(post("/auth/login")
                .param("username", "yuki")
                .param("password", "user")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpectAll(status().isUnauthorized(), content().string(Matchers.containsString("error")));
    }

    @Test
    void cookie() throws Exception {
        mockMvc.perform(get("/auth/user")
                .cookie(new Cookie("username", "yuki")))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("hello yuki")));
    }
}