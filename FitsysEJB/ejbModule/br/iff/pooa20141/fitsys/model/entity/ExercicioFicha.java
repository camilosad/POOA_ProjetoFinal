package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exercicio_ficha database table.
 * 
 */
@Entity
@Table(name="exercicio_ficha")
@NamedQuery(name="ExercicioFicha.findAll", query="SELECT e FROM ExercicioFicha e")
public class ExercicioFicha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String intensidade;

	//bi-directional many-to-one association to Exercicio
	@ManyToOne
	private Exercicio exercicio;

	//bi-directional many-to-one association to Ficha
	@ManyToOne
	private Ficha ficha;

	public ExercicioFicha() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntensidade() {
		return this.intensidade;
	}

	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}

	public Exercicio getExercicio() {
		return this.exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Ficha getFicha() {
		return this.ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

}