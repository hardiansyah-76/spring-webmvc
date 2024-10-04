package yukinarisoftware.mvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class UploadController {

    /*
    * Example for upload file
    * */

    @PostMapping(path = "/upload/profile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String upload(
            @RequestParam(name = "name") String name,
            @RequestPart(name = "profile") MultipartFile profile) throws IOException {

        Path path = Path.of("upload/" + profile.getOriginalFilename());
        profile.transferTo(path);
        return "success upload " + name + " to " + path;
    }

}