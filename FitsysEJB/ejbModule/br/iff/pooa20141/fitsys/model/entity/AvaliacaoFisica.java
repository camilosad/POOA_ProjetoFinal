package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the avaliacao_fisica database table.
 * 
 */
@Entity
@Table(name="avaliacao_fisica")
@NamedQuery(name="AvaliacaoFisica.findAll", query="SELECT a FROM AvaliacaoFisica a")
public class AvaliacaoFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String observacoes;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	private Aluno aluno;

	//bi-directional many-to-one association to ComposicaoCorporal
	@ManyToOne
	@JoinColumn(name="composicao_corporal_id")
	private ComposicaoCorporal composicaoCorporal;

	//bi-directional many-to-one association to Perimetro
	@ManyToOne
	@JoinColumn(name="perimetros_id")
	private Perimetro perimetro;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	private Professor professor;

	public AvaliacaoFisica() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacoes() {
		return this.observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ComposicaoCorporal getComposicaoCorporal() {
		return this.composicaoCorporal;
	}

	public void setComposicaoCorporal(ComposicaoCorporal composicaoCorporal) {
		this.composicaoCorporal = composicaoCorporal;
	}

	public Perimetro getPerimetro() {
		return this.perimetro;
	}

	public void setPerimetro(Perimetro perimetro) {
		this.perimetro = perimetro;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}