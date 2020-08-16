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
import com.minhacarteira.entities.Corretora;
import com.minhacarteira.exceptions.MinhaCarteiraException;
import com.minhacarteira.services.CorretoraService;

@RestController
@RequestMapping("corretoras")
public class CorretoraRestController implements IRestController<Corretora> {

	@Autowired
	private CorretoraService service;

	@Autowired
	private ResponseUtils responseUtils;

	@PostMapping
	@Override
	public ResponseEntity<Response<Corretora>> save(@Valid @RequestBody Corretora corretora, BindingResult result) {
		Response<Corretora> response = new Response<Corretora>();
		ResponseEntity<Response<Corretora>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				corretora = this.service.save(corretora);
				response.setContent(corretora);
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
	public ResponseEntity<Response<Corretora>> update(@Valid @RequestBody Corretora corretora, BindingResult result) {
		Response<Corretora> response = new Response<Corretora>();
		ResponseEntity<Response<Corretora>> responseEntity = null;

		if (result.hasErrors()) {
			this.responseUtils.responseBadRequest(response, result);
			responseEntity = ResponseEntity.badRequest().body(response);
		} else {
			try {
				corretora = this.service.update(corretora);
				response.setContent(corretora);
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
	public ResponseEntity<Response<Corretora>> remove(@PathVariable("id") Corretora corretora) {
		Response<Corretora> response = new Response<Corretora>();
		ResponseEntity<Response<Corretora>> responseEntity = null;

		try {
			this.service.remove(corretora);
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
	public Corretora findById(@PathVariable("id") Corretora corretora) {
		return corretora;
	}

	@GetMapping
	@Override
	public List<Corretora> findAll() {
		return this.service.findAll();
	}

}
