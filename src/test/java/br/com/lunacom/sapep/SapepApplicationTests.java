package br.com.lunacom.sapep;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SapepApplicationTests {

    @Test
    public void contextLoads() {
        Optional<String> emptyOptional = Optional.ofNullable(null);
        String value = emptyOptional.orElse("default Value");
        assertEquals("default Value", value);
    }

}
