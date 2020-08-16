package com.minhacarteira.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.minhacarteira.commons.Response;

public interface IRestController<T> {

	ResponseEntity<Response<T>> save(T t, BindingResult result);
	
	ResponseEntity<Response<T>> update(T t, BindingResult result);
	
	ResponseEntity<Response<T>> remove(T t);
	
	ResponseEntity<Response<T>> findById(Integer id);
	
	ResponseEntity<Response<T>> findAll();
}
