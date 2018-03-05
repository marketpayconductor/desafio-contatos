package br.com.conductor.siscon;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.conductor.siscon.config.AppConfig;
import br.com.conductor.siscon.model.Contato;
import br.com.conductor.siscon.service.ContatoService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppConfig.class)
public class ContatoServiceTest {

	@Autowired
	public ContatoService service;
	
	public Contato contatoInicial;
	
	
	@Before
	public void montaNovoContato(){
		Contato contatoSemGrupo = new Contato();
		contatoSemGrupo.setNome("Edmilson Almeidaaaaaaaaaaaaaaaaa");
		contatoSemGrupo.setEmail("ealmeidaaaaaaaaajunior@gmail.com");
		
	}
	
	@Test
	@Rollback(true)
	public void deveIncluirContatoComSucessoSemGrupoAssociado(){
		try {
			service.salvarContato(contatoInicial);
		} catch (Exception e) {
			fail("Erro ao tentar incluir contato sem um grupo associado.");
		}
	}
	
	@Test
	@Rollback(true)
	public void naoDeveIncluirContatoComMesmoEmail(){
			
		Contato c = new Contato();
		c.setNome("Edmilson Almeida");
		c.setEmail("ealmeidajunior@gmail.com");
		try {
			service.salvarContato(c);
			fail();
		} catch (Exception e) {
			
		}
	}

	@Test
	@Rollback(true)
	public void deveRemoverContatoExistente(){
		try {
			service.removerContatoPorEmail("ealmeidajunior@gmail.com");
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	@Rollback(true)
	public void deveAlterarContatoExistente(){
		try {
			Contato contatoPegarId = service.buscarPorEmail("ealmeidajunior@gmail.com");
			Contato c = new Contato();
			c.setNome("Nome Dois");
			c.setEmail("Email dois");
			c.setIdContato(contatoPegarId.getIdContato());
			service.alterarContato(c);			
		} catch (Exception e) {
			fail("Erro ao tentar alterar um contato existente, que poderia ser alterado.");
		}
	}
	
}
