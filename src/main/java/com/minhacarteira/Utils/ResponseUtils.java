package com.minhacarteira.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.minhacarteira.commons.Response;

@Component
public class ResponseUtils {

	private ResponseUtils() {
	}

	public void responseBadRequest(Response<?> response, String msg) {
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.withMessage(msg);
	}

	public void responseBadRequest(Response<?> response, Errors errors) {
		if (errors.hasErrors()) {
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			errors.getAllErrors().forEach(error -> response.getMessages().add(error.getDefaultMessage()));
		}
	}

	public void responseInternalError(Response<?> response) {
		response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.withMessage("Erro ao salvar!");
	}

	public void responseOk(Response<?> response) {
		response.setHttpStatus(HttpStatus.OK);
		response.setStatus(HttpStatus.OK.value());
		response.withMessage("OK");
	}

	public void responseSaveOk(Response<?> response) {
		response.setHttpStatus(HttpStatus.OK);
		response.setStatus(HttpStatus.OK.value());
		response.withMessage("Salvo com sucesso!");
	}

	public void responseUpdateOk(Response<?> response) {
		response.setHttpStatus(HttpStatus.OK);
		response.setStatus(HttpStatus.OK.value());
		response.withMessage("Editado com sucesso!");
	}

	public void responseRemoveOk(Response<?> response) {
		response.setHttpStatus(HttpStatus.OK);
		response.setStatus(HttpStatus.OK.value());
		response.withMessage("Removido com sucesso!");
	}
}
