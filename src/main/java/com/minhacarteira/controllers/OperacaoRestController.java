package com.minhacarteira.controllers;

import java.util.List;

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
import com.minhacarteira.entities.Operacao;
import com.minhacarteira.services.CorretoraService;

@RestController
@RequestMapping("operacoes")
public class OperacaoRestController implements IRestController<Operacao> {

	@Autowired
	private CorretoraService service;

	@Autowired
	private ResponseUtils responseUtils;

	@PostMapping
	@Override
	public ResponseEntity<Response<Operacao>> save(@RequestBody Operacao t, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping
	@Override
	public ResponseEntity<Response<Operacao>> update(@RequestBody Operacao t, BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("{id}")
	@Override
	public ResponseEntity<Response<Operacao>> remove(@PathVariable("id") Operacao t) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("{id}")
	@Override
	public Operacao findById(@PathVariable("id") Operacao operacao) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping
	@Override
	public List<Operacao> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
