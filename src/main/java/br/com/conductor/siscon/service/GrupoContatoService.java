package br.com.conductor.siscon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conductor.siscon.repository.GrupoContatoRepository;

@Service
public class GrupoContatoService {

	@Autowired 
	private GrupoContatoRepository repository;
}
