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
@Table(name = "telefone_contato", schema = "siscont")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long idContato;

	@Column(name = "numero", nullable = false, length = 100)
	private String numeroTelefone;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_contato", nullable = false)
	private Contato contado;

	public long getIdContato() {
		return idContato;
	}

	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public Contato getContado() {
		return contado;
	}

	public void setContado(Contato contado) {
		this.contado = contado;
	}

}
