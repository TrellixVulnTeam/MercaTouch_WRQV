package co.edu.uco.mercatouch.inicializador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"co.edu.uco.mercatouch"})
@EnableJpaRepositories(basePackages = {"co.edu.uco.mercatouch"})
@EntityScan(basePackages = {"co.edu.uco.mercatouch"})
public class MercaTouchApiApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(MercaTouchApiApplication.class, args);
	}
}
