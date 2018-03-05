package br.com.conductor.siscon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.conductor.siscon.model.Contato;
import br.com.conductor.siscon.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Serializable>{

	public Telefone findByNumeroTelefoneAndContato(String numeroTelefone, Contato contado);

}
