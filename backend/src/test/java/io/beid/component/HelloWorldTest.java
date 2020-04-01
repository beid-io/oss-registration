package io.beid.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HelloWorldTest {

    @Autowired
    private HelloWorld h;

    @Test
    void testSayHi() {
        assert "Hello World".equals(h.sayHi());
    }

}