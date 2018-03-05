package br.com.conductor.siscon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.conductor.siscon.model.Contato;
import br.com.conductor.siscon.service.ContatoService;

@Controller
public class ContatoController {

	@Autowired
	private ContatoService service;

	@RequestMapping(value = "/contatos", method = RequestMethod.GET)
	public ResponseEntity<List<Contato>> listar() {
		List<Contato> listaContatos = service.buscarTodos();
		return new ResponseEntity<List<Contato>>(listaContatos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> buscar(@PathVariable("id") Long id) {
	  Contato contato = service.buscarPorId(id);
	 
	  if (contato == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/contatos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contato> buscar(@PathVariable("id") String email) {
	  Contato contato = service.buscarPorEmail(email);
	 
	  if (contato == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Contato>(contato, HttpStatus.OK);
	}
}
