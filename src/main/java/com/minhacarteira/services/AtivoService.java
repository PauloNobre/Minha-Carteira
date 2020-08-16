package com.minhacarteira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhacarteira.entities.Ativo;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.repositories.AtivoRepository;

@Service
public class AtivoService implements IService<Ativo>{

	@Autowired
	private AtivoRepository repository;
	
	@Override
	public Ativo save(Ativo ativo) throws MinhaCarteiraException {
		return this.repository.save(ativo);
	}

	@Override
	public Ativo update(Ativo ativo) throws MinhaCarteiraException {
		return this.repository.save(ativo);
	}

	@Override
	public void remove(Ativo ativo) throws MinhaCarteiraException {
		this.repository.delete(ativo);
	}

	@Override
	public Ativo findById(Integer id) throws MinhaCarteiraException {
		return this.repository.getOne(id);
	}

	@Override
	public List<Ativo> findAll() {
		return this.repository.findAll();
	}
}