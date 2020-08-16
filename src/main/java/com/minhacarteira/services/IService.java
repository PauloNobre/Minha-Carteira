package com.minhacarteira.services;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.minhacarteira.exceptions.MinhaCarteiraException;

public interface IService<T> {
	
	T save(T t, BindingResult result) throws MinhaCarteiraException;
	
	T update(T t, BindingResult result) throws MinhaCarteiraException;
	
	T remove(T t) throws MinhaCarteiraException;
	
	T findById(Integer id) throws MinhaCarteiraException;
	
	List<T> findAll();
}
