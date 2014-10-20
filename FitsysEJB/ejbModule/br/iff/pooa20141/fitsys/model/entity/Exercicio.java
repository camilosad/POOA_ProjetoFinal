package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the exercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Exercicio.findAll", query="SELECT e FROM Exercicio e")
public class Exercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to ExercicioFicha
	@OneToMany(mappedBy="exercicio")
	private List<ExercicioFicha> exercicioFichas;

	public Exercicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ExercicioFicha> getExercicioFichas() {
		return this.exercicioFichas;
	}

	public void setExercicioFichas(List<ExercicioFicha> exercicioFichas) {
		this.exercicioFichas = exercicioFichas;
	}

	public ExercicioFicha addExercicioFicha(ExercicioFicha exercicioFicha) {
		getExercicioFichas().add(exercicioFicha);
		exercicioFicha.setExercicio(this);

		return exercicioFicha;
	}

	public ExercicioFicha removeExercicioFicha(ExercicioFicha exercicioFicha) {
		getExercicioFichas().remove(exercicioFicha);
		exercicioFicha.setExercicio(null);

		return exercicioFicha;
	}

}