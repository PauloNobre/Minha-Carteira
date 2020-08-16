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
import com.minhacarteira.entities.Ativo;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.services.AtivoService;

@RestController
@RequestMapping("ativos")
public class AtivoRestController implements IRestController<Ativo> {

	@Autowired
	private AtivoService service;

	@Autowired
	private ResponseUtils responseUtils;

	@PostMapping
	@Override
	public ResponseEntity<Response<Ativo>> save(@Valid @RequestBody Ativo ativo, BindingResult result) {
		Response<Ativo> response = new Response<Ativo>();
		ResponseEntity<Response<Ativo>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				ativo = this.service.save(ativo);
				response.setContent(ativo);
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
	public ResponseEntity<Response<Ativo>> update(@Valid @RequestBody Ativo ativo, BindingResult result) {
		Response<Ativo> response = new Response<Ativo>();
		ResponseEntity<Response<Ativo>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				ativo = this.service.update(ativo);
				response.setContent(ativo);
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
	public ResponseEntity<Response<Ativo>> remove(@PathVariable("id") Ativo ativo) {
		Response<Ativo> response = new Response<Ativo>();
		ResponseEntity<Response<Ativo>> responseEntity = null;

		try {
			this.service.remove(ativo);
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
	public Ativo findById(@PathVariable("id") Ativo ativo) {
		return ativo;
	}

	@GetMapping
	@Override
	public List<Ativo> findAll() {
		return this.service.findAll();
	}
}