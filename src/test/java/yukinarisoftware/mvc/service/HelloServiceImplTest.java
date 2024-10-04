package yukinarisoftware.mvc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureMockMvc
class HelloServiceImplTest {

    @Autowired
    private HelloService helloService;


    @Test
    void testHello() {
        Assertions.assertEquals("hello yuki", helloService.hello("yuki"));
        Assertions.assertEquals("hello guest", helloService.hello(null));
    }
}