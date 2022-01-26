package etron.rest.dosi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"etron.rest.dosi"})
public class DosiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DosiApplication.class, args);
	}

}
