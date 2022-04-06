package com.exFilmes.filmes;

import com.exFilmes.filmes.dto.FilmesDTO;
import com.exFilmes.filmes.model.Filme;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilmesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void dto(){
		Filme filme = new Filme(1, "FILME","filme 1", 2);
		ObjectMapper mapper = new ObjectMapper();
		FilmesDTO filmesDTO = mapper.convertValue(filme, FilmesDTO.class);
		System.out.println(filmesDTO);
	}

}
