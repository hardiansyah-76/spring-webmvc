package yukinarisoftware.mvc.controller;

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
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addTodo() throws Exception {
        mockMvc.perform(post("/todo")
                .accept(MediaType.APPLICATION_JSON)
                .param("todo", "java"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString(
                        "java"
                )));
    }

    @Test
    void getTodo() throws Exception {
            mockMvc.perform(get("/todo")
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpectAll(status().isOk(), content().string(Matchers.containsString(
                "java")));
    }

    
}