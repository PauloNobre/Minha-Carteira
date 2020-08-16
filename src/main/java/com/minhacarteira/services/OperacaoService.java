package com.minhacarteira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.minhacarteira.entities.Operacao;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.repositories.OperacaoRepository;

@Service
public class OperacaoService implements IService<Operacao>{
	
	@Autowired
	private OperacaoRepository repository;

	@Override
	public Operacao save(Operacao t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operacao update(Operacao t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operacao remove(Operacao operacao) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operacao findById(Integer id) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Operacao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
