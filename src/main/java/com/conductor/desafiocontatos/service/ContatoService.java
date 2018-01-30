package com.conductor.desafiocontatos.service;

import com.conductor.desafiocontatos.model.Contato;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * This service interface has all the methods used for retrieve data from DB.
 *
 * @author - Cássio Espíndola
 */
public interface ContatoService {
    /**
     * Return a list of all contacts stored in contatos table.
     */
    List<Contato> getAllContatos();

    /**
     * Return one contact with the respective id.
     */
    Contato getContatoById(long id);

    /**
     * Return contacts that matches the name passed as parameter.
     *
     * @param nome - name of the contact.
     */
    List<Contato> getContatosByNome(String nome);

    /**
     * Save a contact in the database.
     *
     * @param contato - Contact to be saved.
     */
    Contato save(Contato contato);

    /**
     * Delete a contact from database.
     *
     * @param contatoId - Id of the contact to be removed.
     */
    ResponseEntity<Contato> deleteContato(Long contatoId);
}
