package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aluno database table.
 * 
 */
@Entity
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer matricula;

	private String nome;

	private String sexo;

	//bi-directional many-to-one association to Academia
	@ManyToOne
	private Academia academia;

	//bi-directional many-to-one association to AvaliacaoFisica
	@OneToMany(mappedBy="aluno")
	private List<AvaliacaoFisica> avaliacaoFisicas;

	//bi-directional many-to-one association to Ficha
	@OneToMany(mappedBy="aluno")
	private List<Ficha> fichas;

	public Aluno() {
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

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(Academia academia) {
		this.academia = academia;
	}

	public List<AvaliacaoFisica> getAvaliacaoFisicas() {
		return this.avaliacaoFisicas;
	}

	public void setAvaliacaoFisicas(List<AvaliacaoFisica> avaliacaoFisicas) {
		this.avaliacaoFisicas = avaliacaoFisicas;
	}

	public AvaliacaoFisica addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().add(avaliacaoFisica);
		avaliacaoFisica.setAluno(this);

		return avaliacaoFisica;
	}

	public AvaliacaoFisica removeAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().remove(avaliacaoFisica);
		avaliacaoFisica.setAluno(null);

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
		ficha.setAluno(this);

		return ficha;
	}

	public Ficha removeFicha(Ficha ficha) {
		getFichas().remove(ficha);
		ficha.setAluno(null);

		return ficha;
	}

}