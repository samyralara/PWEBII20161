package br.edu.ifpb.collegialis.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifpb.collegialis.type.TipoMembro;

@Entity
@Table(name="TB_MEMBRO")
public class Membro {
	@Id
	@Column (name="NU_ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column (name="TP_MEMBRO")
	private TipoMembro tipo;
	
	@OneToOne (cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="NU_ID_ALUNO", foreignKey=@ForeignKey(name = "FK_ALUNO"))
	private Aluno aluno;
	
	@OneToOne (cascade= {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn (name="NU_ID_PROFESSOR", foreignKey=@ForeignKey(name = "FK_PROFESSOR"))
	private Professor professor;
	
	@ManyToOne
	@JoinColumn (name="NU_ID_COLEGIADO", foreignKey=@ForeignKey(name = "FK_COLEGIADO"))
	private Colegiado colegiado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Colegiado getColegiado() {
		return colegiado;
	}

	public void setColegiado(Colegiado colegiado) {
		this.colegiado = colegiado;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		this.tipo = TipoMembro.ALUNO;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		this.tipo = TipoMembro.PROFESSOR;
	}
}
