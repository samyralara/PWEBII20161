package br.edu.ifpb.collegialis.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollectionOption;

import br.edu.ifpb.collegialis.type.TipoDecisao;

@Entity
@Table(name="TB_PROCESSO")
public class Processo {
	@Id
	@Column(name="NU_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NU_PROCESSO")
	private String numero;
	
	@Column(name="DT_RECEPCAO")
	private Date dataRecepcao;
	
	@Column(name="DT_DISTRIBUICAO")
	private Date dataDistribuicao;
	
	@Column(name="DT_PARECER")
	private Date dataParecer;
	
	@Lob
	@Column(name="LB_PARECER")
	private byte[] parecer;
	
	@Column(name="TP_DECISAO")
	@Enumerated(EnumType.STRING)
	private TipoDecisao decisao;
	
	@OneToOne
	@JoinColumn(name="ID_ASSUNTO", foreignKey=@ForeignKey(name = "FK_ASSUNTO"))
	private Assunto assunto;
	
	@OneToMany (mappedBy="processo")
	@org.hibernate.annotations.LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Voto> votos;
	
	@OneToOne
	@JoinColumn(name="ID_RELATOR", foreignKey=@ForeignKey(name = "FK_RELATOR"))
	private Membro relator;
	
	@OneToOne
	@JoinColumn(name="ID_REQUISITANTE", foreignKey=@ForeignKey(name = "FK_REQUISITANTE"))
	private Aluno requisitante;
	
	@ManyToOne
	@JoinColumn(name = "ID_REUNIAO", foreignKey=@ForeignKey(name = "FK_REUNIAO"))
	private Reuniao reuniao;
	
	@Lob
	@Column(name="LB_DESCRICAOALU")
	private byte[] descricaoAlu;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDataRecepcao() {
		return dataRecepcao;
	}

	public void setDataRecepcao(Date dataRecepcao) {
		this.dataRecepcao = dataRecepcao;
	}

	public Date getDataDistribuicao() {
		return dataDistribuicao;
	}

	public void setDataDistribuicao(Date dataDistribuicao) {
		this.dataDistribuicao = dataDistribuicao;
	}

	public Date getDataParecer() {
		return dataParecer;
	}

	public void setDataParecer(Date dataParecer) {
		this.dataParecer = dataParecer;
	}

	public byte[] getParecer() {
		return parecer;
	}

	public void setParecer(byte[] parecer) {
		this.parecer = parecer;
	}

	public TipoDecisao getDecisao() {
		return decisao;
	}

	public void setDecisao(TipoDecisao decisao) {
		this.decisao = decisao;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Set<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}


	public void setReuniao(Reuniao reuniao) {
		this.reuniao = reuniao;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public Membro getRelator() {
		return relator;
	}

	public void setRelator(Membro relator) {
		this.relator = relator;
	}

	public Aluno getRequisitante() {
		return requisitante;
	}

	public void setRequisitante(Aluno requisitante) {
		this.requisitante = requisitante;
	}

	public byte[] getDescricaoAlu() {
		return descricaoAlu;
	}

	public void setDescricaoAlu(byte[] descricaoAlu) {
		this.descricaoAlu = descricaoAlu;
		
	}

}
