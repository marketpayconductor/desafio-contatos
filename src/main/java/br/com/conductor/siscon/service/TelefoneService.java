package br.com.conductor.siscon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conductor.siscon.model.Telefone;
import br.com.conductor.siscon.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository repository;
	
	public List<Telefone> buscarTodos(){
		return repository.findAll();
	}

	public void salvarTelefoneContato(Telefone telefone) throws Exception {
		verificarExisteMesmoTelefoneParaContato(telefone);
		
	}

	private void verificarExisteMesmoTelefoneParaContato(Telefone telefone) throws Exception {
		
		Telefone telefoneBanco = repository
				.findByNumeroTelefoneAndContato(telefone.getNumeroTelefone(),telefone.getContado());
		if(telefoneBanco != null){
			throw new Exception(); // Deveria lançar uma exceção com mensagem de negócio.
		}
		
	}
}
