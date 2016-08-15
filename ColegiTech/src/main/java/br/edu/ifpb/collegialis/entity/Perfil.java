package br.edu.ifpb.collegialis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifpb.collegialis.type.TipoPerfil;

@Entity
@Table(name="TB_PERFIL")
public class Perfil {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_NOME")
	private TipoPerfil nome;
	
	@Column(name="DS_DESCRICAO")
	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoPerfil getNome() {
		return nome;
	}

	public void setNome(TipoPerfil nome) {
		this.nome = nome;
	}
	
}
