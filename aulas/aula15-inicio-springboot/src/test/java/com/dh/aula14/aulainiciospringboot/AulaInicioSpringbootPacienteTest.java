package com.dh.aula14.aulainiciospringboot;

import com.dh.aula14.aulainiciospringboot.dao.impl.DentistaDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.impl.EnderecoDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.impl.PacienteDAOMySQL;
import com.dh.aula14.aulainiciospringboot.dao.impl.UsuarioDaoMySQL;
import com.dh.aula14.aulainiciospringboot.dao.service.DentistaService;
import com.dh.aula14.aulainiciospringboot.dao.service.EnderecoService;
import com.dh.aula14.aulainiciospringboot.dao.service.PacienteService;
import com.dh.aula14.aulainiciospringboot.dao.service.UsuarioService;
import com.dh.aula14.aulainiciospringboot.model.Dentista;
import com.dh.aula14.aulainiciospringboot.model.Endereco;
import com.dh.aula14.aulainiciospringboot.model.Paciente;
import com.dh.aula14.aulainiciospringboot.model.Usuario;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest

class AulaInicioSpringbootPacienteTest {
	private PacienteService pacienteService = new PacienteService();

	private static final Paciente p1 = new Paciente("denny",
			"ribeiro", "1232132311", new Date(), new Endereco("Rua 1", 600, "Fortaleza",
			"esss", "CE"));
	private static final Paciente p2 = new Paciente("leylane",
			"joyce", "32132123132", new Date(), new Endereco("Rua 2", 600, "Fortaleza",
			"esss", "PE"));
	private static final Paciente p3 = new Paciente("w",
			"as", "1232132311", new Date(), new Endereco("Rua 3", 600, "Fortaleza",
			"esss", "AL"));

	//@Disabled
	@Test
	void contextLoads() {
	}

	@Disabled
	@Test
	public void salvandoPacientes(){
		System.out.println(pacienteService.salvar(p1));
		System.out.println(pacienteService.salvar(p2));
		System.out.println(pacienteService.salvar(p3));
	}

	@Test
	public void buscandoPacientes(){
		System.out.println(pacienteService.buscar(p1.getId()));
		System.out.println(pacienteService.buscar(3));
		System.out.println(pacienteService.buscar(2));
	}

	@Test
	public void excluindoPacientes(){
		pacienteService.excluir(3);
	}

	@Test
	public void buscandoTodosPacientes(){
		System.out.println(pacienteService.buscarTodos());
	}

	@Test
	public void atualizando(){
		final Endereco enderecoAtualizar = new Endereco(4,
				"Testeeeeeeeeeeee",
				100,
				"teste2",
				"Teste",
				"TE"
		);
		final Paciente pacienteAtualizar = new Paciente(1,
				"testeeeeeeeeeeeeeeeee",
				"teste2",
				"teste3", enderecoAtualizar);

		pacienteService.atualizar(pacienteAtualizar);
		// tem que criar um novo objeto para o atualizar funcionar. Podemos
		// preservar as informações criando um novo objeto, mas passando
		// o mesmo id de antes.

	}



}
