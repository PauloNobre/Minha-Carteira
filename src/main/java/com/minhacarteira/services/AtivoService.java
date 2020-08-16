package com.minhacarteira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.minhacarteira.entities.Ativo;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.repositories.AtivoRepository;

@Service
public class AtivoService implements IService<Ativo>{

	@Autowired
	private AtivoRepository repository;
	
	@Override
	public Ativo save(Ativo t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ativo update(Ativo t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ativo remove(Ativo ativo) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ativo findById(Integer id) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ativo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
