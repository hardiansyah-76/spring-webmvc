package yukinarisoftware.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import yukinarisoftware.mvc.model.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUserValid() throws Exception {
        mockMvc.perform(get("/user/current")
                        .sessionAttr("user", new User("yuki")))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("hello yuki")));
    }

    @Test
    void testUserInvalid() throws Exception {
        mockMvc.perform(get("/user/current")
                ).andExpectAll(status().is3xxRedirection());
    }
}