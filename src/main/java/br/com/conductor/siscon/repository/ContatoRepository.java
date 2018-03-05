package br.com.conductor.siscon.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.conductor.siscon.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Serializable>{

	public Contato findByEmail(String email);

	public List<Contato> findByNome(String nome);

}
