package yukinarisoftware.mvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UploadControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    

    @Test
    void testUpload() throws Exception {
        mockMvc.perform(
                multipart("/upload/profile")
                        .file(new MockMultipartFile("profile", "profile.jpg", "image/jpg",
                                getClass().getResourceAsStream("/images/profile.jpg")))
                        .param("name", "yuki")
                        .contentType(MediaType.MULTIPART_FORM_DATA)
        ).andExpectAll(status().isOk(),
                content().string(Matchers.containsString("success save profile yuki to upload/profile.jpg")));
    }
}