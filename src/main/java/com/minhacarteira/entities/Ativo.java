package com.minhacarteira.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.minhacarteira.enums.TipoAtivo;

@Entity
public class Ativo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ativo_sequence")
	@SequenceGenerator(name = "ativo_sequence", sequenceName = "ativo_sequence")
	private Integer id;
	
	@Size(max = 50, message = "Nome inválido")
	private String nome;
	
	@Column(unique = true)
	@NotEmpty(message = "O Código é obrigatório")
	@Size(max = 10, message = "O Código deve ter no máximo 10 caracteres")
	private String codigo;
	
	@NotNull(message = "O Tipo é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoAtivo tipo;

	public Ativo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoAtivo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtivo tipo) {
		this.tipo = tipo;
	}
}