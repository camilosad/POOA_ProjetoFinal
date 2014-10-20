package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ficha database table.
 * 
 */
@Entity
@NamedQuery(name="Ficha.findAll", query="SELECT f FROM Ficha f")
public class Ficha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.DATE)
	@Column(name="data_validade")
	private Date dataValidade;

	@Column(name="dia_da_semana")
	private String diaDaSemana;

	private String objetivo;

	//bi-directional many-to-one association to ExercicioFicha
	@OneToMany(mappedBy="ficha")
	private List<ExercicioFicha> exercicioFichas;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	private Aluno aluno;

	//bi-directional many-to-one association to Professor
	@ManyToOne
	private Professor professor;

	public Ficha() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataValidade() {
		return this.dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDiaDaSemana() {
		return this.diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<ExercicioFicha> getExercicioFichas() {
		return this.exercicioFichas;
	}

	public void setExercicioFichas(List<ExercicioFicha> exercicioFichas) {
		this.exercicioFichas = exercicioFichas;
	}

	public ExercicioFicha addExercicioFicha(ExercicioFicha exercicioFicha) {
		getExercicioFichas().add(exercicioFicha);
		exercicioFicha.setFicha(this);

		return exercicioFicha;
	}

	public ExercicioFicha removeExercicioFicha(ExercicioFicha exercicioFicha) {
		getExercicioFichas().remove(exercicioFicha);
		exercicioFicha.setFicha(null);

		return exercicioFicha;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}