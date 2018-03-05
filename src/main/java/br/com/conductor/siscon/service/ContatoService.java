package br.com.conductor.siscon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conductor.siscon.model.Contato;
import br.com.conductor.siscon.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository repository;
	
	public Contato salvarContato(Contato contato) throws Exception{
		verificarContatoMesmoEmail(contato);
		return repository.saveAndFlush(contato);
	}
	
	public List<Contato> buscarTodos(){
		return repository.findAll();
	}
	
	public Contato alterarContato(Contato contato){
		
		Contato contatoGerenciadoJPA = repository.findOne(contato.getIdContato());
		contatoGerenciadoJPA = contato;
		return repository.saveAndFlush(contatoGerenciadoJPA);
	}

	private void verificarContatoMesmoEmail(Contato contato) throws Exception {
		Contato contatoJaCadastrado = buscarPorEmail(contato.getEmail());
		if(contatoJaCadastrado != null){
			throw new Exception();
		}
	}
	
	public Contato buscarPorEmail(String email){
		return repository.findByEmail(email);
	}
	
	public List<Contato> buscarPorNome(String nome){
		return repository.findByNome(nome);
	}
	
	
}
