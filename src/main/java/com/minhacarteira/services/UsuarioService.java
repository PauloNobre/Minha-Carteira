package com.minhacarteira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.minhacarteira.entities.Usuario;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IService<Usuario>{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario save(Usuario t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario t, BindingResult result) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario remove(Usuario usuario) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(Integer id) throws MinhaCarteiraException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
