package com.dh.aula14.aulainiciospringboot;

import com.dh.aula14.aulainiciospringboot.dao.impl.EnderecoDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.impl.UsuarioDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.service.DentistaService;
import com.dh.aula14.aulainiciospringboot.dao.impl.DentistaDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.service.EnderecoService;
import com.dh.aula14.aulainiciospringboot.dao.service.UsuarioService;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Endereco;
import com.dh.aula14.aulainiciospringboot.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AulaInicioSpringbootDentistaTest {

	private static final DentistaService dentistaService = new DentistaService(new DentistaDaoMySQL());
	private static final EnderecoService enderecoService = new EnderecoService(new EnderecoDaoMySQL());
	private static final UsuarioService usuarioService = new UsuarioService(new UsuarioDaoMySQL());
	@Test
	void contextLoads() {
	}




	@Test
	public void carregarDentistas(){
		Dentista d1 = new Dentista("Carlos", "Carlos.gmail.com", 0, 1);
		Dentista d2 = new Dentista("Pedro", "pedro.gmail.com", 1, 1);
		Dentista d3 = new Dentista("Jose", "jose.gmail.com", 2, 0);


		dentistaService.salvar(d1);
		dentistaService.salvar(d2);
		dentistaService.salvar(d3);
	}

	@Test
	public void deletarDentista(){
		Dentista d3 = new Dentista("Joyce", "joyce.gmail.com", 2, 0);
		Dentista d4 = new Dentista("Denny", "Denny.gmail.com", 2, 0);
		dentistaService.salvar(d3);
		dentistaService.salvar(d4);
		dentistaService.delete(d3.getId());
	}

	@Test
	public void consultar(){
		dentistaService.buscar(1);
		Dentista d3 = new Dentista("Joyce", "joyce.gmail.com", 2, 0);
		dentistaService.salvar(d3);
		dentistaService.buscar(1);
		dentistaService.buscar(d3);

	}

	@Test
	public void testarEnderecos(){


		Endereco e1 = new Endereco("A", 12, "Fortaleza", "Tráfico", "CE");
		Endereco e2 = new Endereco("B", 13, "Recife", "de", "PE");
		Endereco e3 = new Endereco("C", 14, "São Paulo", "dorgas", "SP");
		Endereco e4 = new Endereco("D", 15, "LAgoa", "pesadas", "AL");

		enderecoService.salvar(e1);
		enderecoService.salvar(e2);
		enderecoService.salvar(e3);
		enderecoService.salvar(e4);

		enderecoService.buscarTodos();
		enderecoService.buscar(e1);
		enderecoService.buscar(3);
		enderecoService.delete(e1.getId());

	}

	@Test
	public void testandoUsuario(){


		Usuario u1 = new Usuario("Denny", "ribeiro@outlook.com", "3435", 3);
		Usuario u2 = new Usuario("Joyce", "joyce@outlook.com", "1034", 4);


		usuarioService.salvar(u1);
		usuarioService.salvar(u2);
		usuarioService.buscar(1);
		usuarioService.buscar(u2.getId());
		usuarioService.delete(1);

	}

}
