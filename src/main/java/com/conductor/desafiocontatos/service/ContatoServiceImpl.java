package com.conductor.desafiocontatos.service;

import com.conductor.desafiocontatos.model.Contato;
import com.conductor.desafiocontatos.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class implements all the methods used to retrieve data from DB.
 *
 * @author - Cássio Espíndola
 */
@Service("contatoServiceImpl")
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato getContatoById(long id) {
        return contatoRepository.findOne(id);
    }

    @Override
    public List<Contato> getContatosByNome(String nome) {
        return contatoRepository.findAllByNome(nome);
    }

    @Override
    public Contato save(Contato contato) {
        return contatoRepository.saveAndFlush(contato);
    }

    @Override
    public ResponseEntity<Contato> deleteContato(Long contatoId) {
        Contato contato = contatoRepository.findOne(contatoId);
        if (contato == null) {
            return ResponseEntity.notFound().build();
        }
        contatoRepository.delete(contato);
        return ResponseEntity.ok().build();
    }
}
