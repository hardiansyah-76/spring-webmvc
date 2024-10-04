package yukinarisoftware.mvc.controller;

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
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "kinoshita")
                        .param("lastName", "yuki")
                        .param("email", "kinoshita@example.com")
                        .param("phone", "1234")
                        .param("address.city", "sapporo")
                        .param("address.country", "japan")
                        .param("hobbies[0]", "coding")
                        .param("hobbies[1]", "gaming")
                        .param("hobbies[2]", "programming")
                        .param("socialMedia[0].name","fb")
                        .param("socialMedia[0].location", "www.fb.com")
                        .param("socialMedia[1].name","x")
                        .param("socialMedia[1].location", "www.eks.com"))
                .andExpectAll(status().isOk());
    }

    @Test
    void testValidation() throws Exception {
        mockMvc.perform(post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                      //  .param("firstName", "kinoshita")
                        .param("lastName", "yuki")
                      //  .param("email", "kinoshita@example.com")
                        .param("phone", "1234")
                        .param("address.city", "sapporo")
                        .param("address.country", "japan")
                        .param("hobbies[0]", "coding")
                        .param("hobbies[1]", "gaming")
                        .param("hobbies[2]", "programming")
                        .param("socialMedia[0].name","fb")
                        .param("socialMedia[0].location", "www.fb.com")
                        .param("socialMedia[1].name","x")
                        .param("socialMedia[1].location", "www.eks.com"))
                .andExpectAll(status().isBadRequest());
    }
}