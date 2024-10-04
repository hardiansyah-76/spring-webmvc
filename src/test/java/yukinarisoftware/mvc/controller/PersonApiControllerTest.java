package yukinarisoftware.mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import yukinarisoftware.mvc.model.CreateAddressRequest;
import yukinarisoftware.mvc.model.CreatePersonRequest;
import yukinarisoftware.mvc.model.CreateSocialMediaRequest;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void test() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("kinoshita");
        request.setLastName("yuki");
        request.setEmail("yuki@example.jp");
        request.setPhone("0123456");
        request.setHobbies(List.of("coding", "gaming", "reading"));
        request.setAddress(new CreateAddressRequest("sapporo", "japan"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("fb","fb.com"));
        request.getSocialMedia().add(new CreateSocialMediaRequest("x", "eks.com"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpectAll(status().isOk(), content().json(jsonRequest));
    }

    @Test
    void testValidation() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
      //  request.setFirstName("kinoshita");
        request.setLastName("yuki");
      //  request.setEmail("yuki@example.jp");
        request.setPhone("0123456");
        request.setHobbies(List.of("coding", "gaming", "reading"));
        request.setAddress(new CreateAddressRequest("sapporo", "japan"));
        request.setSocialMedia(new ArrayList<>());
        request.getSocialMedia().add(new CreateSocialMediaRequest("fb","fb.com"));
        request.getSocialMedia().add(new CreateSocialMediaRequest("x", "eks.com"));

        String jsonRequest = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(jsonRequest)).andExpectAll(status().isBadRequest(), content()
                .string(Matchers.containsString("validation error")));
    }


}