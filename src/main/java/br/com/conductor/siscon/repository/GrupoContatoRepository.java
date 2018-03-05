package br.com.conductor.siscon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.conductor.siscon.model.Contato;

public interface GrupoContatoRepository extends JpaRepository<Contato, Serializable>{

}
