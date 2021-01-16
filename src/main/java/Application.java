import br.com.UseCaseImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan("br.com")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
        UseCaseImpl useCaseImpl = ctx.getBean(UseCaseImpl.class);
        try {
            useCaseImpl.execute();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }
}
