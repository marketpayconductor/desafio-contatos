package br.com.conductor.siscon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contato", schema = "siscont")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long idContato;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupo_contato", nullable = true)
	private GrupoContato grupo;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "contato")
	//private Set<Telefone> telefones;
	
	public long getIdContato() {
		return idContato;
	}
	
	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GrupoContato getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoContato grupo) {
		this.grupo = grupo;
	}


}
