package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the professor database table.
 * 
 */
@Entity
@NamedQuery(name="Professor.findAll", query="SELECT p FROM Professor p")
public class Professor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer matricula;

	private String nome;

	//bi-directional many-to-one association to AvaliacaoFisica
	@OneToMany(mappedBy="professor")
	private List<AvaliacaoFisica> avaliacaoFisicas;

	//bi-directional many-to-one association to Ficha
	@OneToMany(mappedBy="professor")
	private List<Ficha> fichas;

	//bi-directional many-to-one association to Academia
	@ManyToOne
	private Academia academia;

	public Professor() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatricula() {
		return this.matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AvaliacaoFisica> getAvaliacaoFisicas() {
		return this.avaliacaoFisicas;
	}

	public void setAvaliacaoFisicas(List<AvaliacaoFisica> avaliacaoFisicas) {
		this.avaliacaoFisicas = avaliacaoFisicas;
	}

	public AvaliacaoFisica addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().add(avaliacaoFisica);
		avaliacaoFisica.setProfessor(this);

		return avaliacaoFisica;
	}

	public AvaliacaoFisica removeAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().remove(avaliacaoFisica);
		avaliacaoFisica.setProfessor(null);

		return avaliacaoFisica;
	}

	public List<Ficha> getFichas() {
		return this.fichas;
	}

	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}

	public Ficha addFicha(Ficha ficha) {
		getFichas().add(ficha);
		ficha.setProfessor(this);

		return ficha;
	}

	public Ficha removeFicha(Ficha ficha) {
		getFichas().remove(ficha);
		ficha.setProfessor(null);

		return ficha;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

}