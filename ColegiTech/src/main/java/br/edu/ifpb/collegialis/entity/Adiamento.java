package br.edu.ifpb.collegialis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ADIAMENTO")
public class Adiamento {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DS_MOTIVO")
	private String motivo;
	
	@OneToOne
	@JoinColumn(name="ID_PROCESSO")
	private Processo processo;
	
	@OneToOne
	@JoinColumn(name="ID_REUNIAO")
	private Reuniao reuniao;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}
	
}
