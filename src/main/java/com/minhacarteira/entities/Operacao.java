package com.minhacarteira.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.minhacarteira.enums.TipoOperacao;

@Entity
public class Operacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operacao_sequence")
	@SequenceGenerator(name = "operacao_sequence", sequenceName = "operacao_sequence")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "corretora_id")
	@NotNull(message = "A Corretora é obrigatória")
	private Corretora corretora;

	@NotNull(message = "O Tipo é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoOperacao tipo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ativo_id")
	@NotNull(message = "O Ativo é obrigatório")
	private Ativo ativo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A Data é obrigatória")
	private Date data;

	@Min(1)
	private int quantidade;

	@NotNull(message = "O Preço Unitário é obrigatório")
	private BigDecimal pu;

	private BigDecimal emolumentos;

	private BigDecimal taxaLiquidacao;

	private BigDecimal taxaRegistro;

	private BigDecimal irrf;

	public Operacao() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Corretora getCorretora() {
		return corretora;
	}

	public void setCorretora(Corretora corretora) {
		this.corretora = corretora;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPu() {
		return pu;
	}

	public void setPu(BigDecimal pu) {
		this.pu = pu;
	}

	public BigDecimal getEmolumentos() {
		return emolumentos;
	}

	public void setEmolumentos(BigDecimal emolumentos) {
		this.emolumentos = emolumentos;
	}

	public BigDecimal getTaxaLiquidacao() {
		return taxaLiquidacao;
	}

	public void setTaxaLiquidacao(BigDecimal taxaLiquidacao) {
		this.taxaLiquidacao = taxaLiquidacao;
	}

	public BigDecimal getTaxaRegistro() {
		return taxaRegistro;
	}

	public void setTaxaRegistro(BigDecimal taxaRegistro) {
		this.taxaRegistro = taxaRegistro;
	}

	public BigDecimal getIrrf() {
		return irrf;
	}

	public void setIrrf(BigDecimal irrf) {
		this.irrf = irrf;
	}
}