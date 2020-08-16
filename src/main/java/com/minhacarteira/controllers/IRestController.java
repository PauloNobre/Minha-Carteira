package com.minhacarteira.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.minhacarteira.commons.Response;

public interface IRestController<T> {

	ResponseEntity<Response<T>> save(T t, BindingResult result);

	ResponseEntity<Response<T>> update(T t, BindingResult result);

	ResponseEntity<Response<T>> remove(T t);

	T findById(T t);

	List<T> findAll();
}
