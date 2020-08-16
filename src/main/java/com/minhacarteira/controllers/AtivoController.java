package com.minhacarteira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhacarteira.Utils.ResponseUtils;
import com.minhacarteira.commons.Response;
import com.minhacarteira.entities.Ativo;
import com.minhacarteira.services.AtivoService;

@RestController
@RequestMapping("ativos")
public class AtivoController implements IRestController<Ativo> {

	@Autowired
	private AtivoService service;

	@Autowired
	private ResponseUtils responseUtils;

	@PostMapping
	@Override
	public ResponseEntity<Response<Ativo>> save(@RequestBody Ativo t, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping
	@Override
	public ResponseEntity<Response<Ativo>> update(@RequestBody Ativo t, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("{id}")
	@Override
	public ResponseEntity<Response<Ativo>> remove(@PathVariable("id") Ativo t) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("{id}")
	@Override
	public ResponseEntity<Response<Ativo>> findById(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping
	@Override
	public ResponseEntity<Response<Ativo>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}