package br.edu.ifpb.collegialis.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DS_NOME")
	private String nome;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	@Column(name="DS_SENHA")
	private String senha;
	
	@Column(name="ST_ATIVO")
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name="TB_USUARIO_PERFIL", 
				joinColumns=@JoinColumn(name="ID_USUARIO", foreignKey=@ForeignKey(name = "FK_USUARIO")), 
				inverseJoinColumns=@JoinColumn(name="ID_PERFIL", foreignKey=@ForeignKey(name = "FK_PERFIL")))
	private Set<Perfil> perfis;
	
	public String getPrenome() {
		return  (this.nome != null) ? this.nome.split(" ")[0].trim() : null;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	public Usuario addPerfil(Perfil p) {
		if (this.perfis == null) {
			this.perfis = new HashSet<Perfil>();
		}
		this.perfis.add(p);
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
