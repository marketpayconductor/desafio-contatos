package br.com.conductor.siscon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_contato", schema = "siscont")
public class GrupoContato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long idgrupo;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo_contato")
	//private Set<Contato> contatos;
}
