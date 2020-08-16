package com.minhacarteira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minhacarteira.entities.Corretora;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.repositories.CorretoraRepository;

@Service
public class CorretoraService implements IService<Corretora>{
	
	@Autowired
	private CorretoraRepository repository;

	@Override
	public Corretora save(Corretora t) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corretora update(Corretora t) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Corretora corretora) throws MinhaCarteiraException {
	}

	@Override
	public Corretora findById(Integer id) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Corretora> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
