package com.minhacarteira.services;

import java.util.List;

import com.minhacarteira.exceptions.MinhaCarteiraException;

public interface IService<T> {
	
	T save(T t) throws MinhaCarteiraException;
	
	T update(T t) throws MinhaCarteiraException;
	
	void remove(T t) throws MinhaCarteiraException;
	
	T findById(Integer id) throws MinhaCarteiraException;
	
	List<T> findAll();
}
