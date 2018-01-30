package com.conductor.desafiocontatos.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Model class.
 * This class represents our Contato data.
 *
 * @Entity - Indicates Spring that this class represents an Entity on database.
 * @Table - Indicates Spring that this model has the columns attributes.
 * @Id - Marks a field as a primary key field.
 * @GeneratedValue - Generates automatically a value to the id field.
 * @Column - Indicates that the data represents a column on database.
 * @NotBlank -  Do not permit this field be blank.
 */
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "endereco")
    private String endereco;

    @Column(name = "fone")
    private String fone;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
