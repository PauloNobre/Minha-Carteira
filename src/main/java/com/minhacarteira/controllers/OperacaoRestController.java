package com.minhacarteira.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.services.OperacaoService;

@RestController
@RequestMapping("operacoes")
public class OperacaoRestController implements IRestController<Operacao> {

	@Autowired
	private OperacaoService service;

	@Autowired
	private ResponseUtils responseUtils;

	@PostMapping
	@Override
	public ResponseEntity<Response<Operacao>> save(@Valid @RequestBody Operacao operacao, BindingResult result) {
		Response<Operacao> response = new Response<Operacao>();
		ResponseEntity<Response<Operacao>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				operacao = this.service.save(operacao);
				response.setContent(operacao);
				this.responseUtils.responseSaveOk(response);
				responseEntity = ResponseEntity.ok().body(response);
			} catch (MinhaCarteiraException e) {
				this.responseUtils.responseBadRequest(response, e.getMessage());
				responseEntity = ResponseEntity.badRequest().body(response);
			} catch (Exception e) {
				this.responseUtils.responseInternalError(response);
				responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}

		return responseEntity;
	}

	@PutMapping
	@Override
	public ResponseEntity<Response<Operacao>> update(@Valid @RequestBody Operacao operacao, BindingResult result) {
		Response<Operacao> response = new Response<Operacao>();
		ResponseEntity<Response<Operacao>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				operacao = this.service.update(operacao);
				response.setContent(operacao);
				this.responseUtils.responseUpdateOk(response);
				responseEntity = ResponseEntity.ok().body(response);
			} catch (MinhaCarteiraException e) {
				this.responseUtils.responseBadRequest(response, e.getMessage());
				responseEntity = ResponseEntity.badRequest().body(response);
			} catch (Exception e) {
				this.responseUtils.responseInternalError(response);
				responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}

		return responseEntity;
	}

	@DeleteMapping("{id}")
	@Override
	public ResponseEntity<Response<Operacao>> remove(@PathVariable("id") Operacao operacao) {
		Response<Operacao> response = new Response<Operacao>();
		ResponseEntity<Response<Operacao>> responseEntity = null;

		try {
			this.service.remove(operacao);
			this.responseUtils.responseRemoveOk(response);
			responseEntity = ResponseEntity.ok().body(response);
		} catch (MinhaCarteiraException e) {
			this.responseUtils.responseBadRequest(response, e.getMessage());
			responseEntity = ResponseEntity.badRequest().body(response);
		} catch (Exception e) {
			this.responseUtils.responseInternalError(response);
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}

		return responseEntity;
	}

	@GetMapping("{id}")
	@Override
	public Operacao findById(@PathVariable("id") Operacao operacao) {
		return operacao;
	}

	@GetMapping
	@Override
	public List<Operacao> findAll() {
		return this.service.findAll();
	}

}
