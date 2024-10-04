package yukinarisoftware.mvc.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWithName() throws Exception {
        mockMvc.perform(get("/hello")
        .queryParam("name", "yuki"))
        .andExpectAll(status().isOk(), content().string(Matchers.containsString("hello yuki")));
    }

    @Test
    void testWithoutName() throws Exception {
        mockMvc.perform(get("/hello"))
        .andExpectAll(status().isOk(), content().string(Matchers.containsString("hello guest")));
    }


    @Test
    void helloForm() throws Exception {
        mockMvc.perform(post("/form/hello")
                .queryParam("name", "yuki")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpectAll(status().isOk(), header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        content().string(Matchers.containsString("hello yuki")));
    }

    @Test
    void helloModelViewTest() throws Exception {
        mockMvc.perform(
                get("/web/hello").queryParam("name", "yuki")
        ).andExpectAll(status().isOk(),
                content().string(Matchers.containsString("belajar view")),
                content().string(Matchers.containsString("hello yuki")));
    }
}
