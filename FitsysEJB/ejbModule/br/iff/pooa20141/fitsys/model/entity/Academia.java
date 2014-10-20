package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the academia database table.
 * 
 */
@Entity
@NamedQuery(name="Academia.findAll", query="SELECT a FROM Academia a")
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String cidade;

	private String endereco;

	private String nome;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="academia")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Professor
	@OneToMany(mappedBy="academia")
	private List<Professor> professors;

	public Academia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setAcademia(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setAcademia(null);

		return aluno;
	}

	public List<Professor> getProfessors() {
		return this.professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Professor addProfessor(Professor professor) {
		getProfessors().add(professor);
		professor.setAcademia(this);

		return professor;
	}

	public Professor removeProfessor(Professor professor) {
		getProfessors().remove(professor);
		professor.setAcademia(null);

		return professor;
	}

}