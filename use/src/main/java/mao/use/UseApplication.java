package mao.use;

import mao.toolsvalidator.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFormValidator
public class UseApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(UseApplication.class, args);
    }

}
