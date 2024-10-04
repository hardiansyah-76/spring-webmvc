package yukinarisoftware.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HeaderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testRequestHeader() throws Exception {
        mockMvc.perform(get("/header/token")
                .header("X-TOKEN", "xxx"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("ok")));
    }

    @Test
    void testRequestHeaderError() throws Exception {
        mockMvc.perform(get("/header/token")
                        .header("X-TOKEN", "123"))
                .andExpectAll(status().isOk(), content().string(Matchers.containsString("error")));
    }
}