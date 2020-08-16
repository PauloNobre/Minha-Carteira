package com.minhacarteira.commons;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;

	private Integer status;

	private String title;

	private Set<String> messages = new HashSet<>();

	private T content;

	public Response() {
		this(HttpStatus.OK);
		this.status = 0;
		this.title = "";
	}

	public Response(HttpStatus status) {
		this(status, null, null);
	}

	public Response(HttpStatus status, T content) {
		this(status, content, null);
	}

	public Response(HttpStatus httpStatus, T content, String title) {
		this.httpStatus = httpStatus;
		this.content = content;
		this.title = title;
	}

	public Response<T> withStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		return this;
	}

	public Response<T> withTitle(String title) {
		this.title = title;
		return this;
	}

	public Response<T> withContent(T content) {
		this.content = content;
		return this;
	}

	public Response<T> withMessage(String message) {
		this.getMessages().add(message);
		return this;
	}

	public ResponseEntity<Response<T>> build() {
		return new ResponseEntity<Response<T>>(this, this.httpStatus);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<String> getMessages() {
		return messages;
	}

	public void setMessages(Set<String> messages) {
		this.messages = messages;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
}
