package com.dh.aula14.aulainiciospringboot;

import com.dh.aula14.aulainiciospringboot.dao.config.ConfigJDBC;
import com.dh.aula14.aulainiciospringboot.model.Endereco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;

@SpringBootApplication
@RestController
public class AulaInicioSpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(AulaInicioSpringbootApplication.class, args);

	}
	@GetMapping("/hello")
	public String ola(){
		ConfigJDBC configJDBC = new ConfigJDBC();
		configJDBC.conectarComBancoDeDados();
		return "conectado com bd";
	}
}
