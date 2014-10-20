package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;

@Stateless
@LocalBean
public class ProfessorPersistence extends AbstractPersistence implements
		ProfessorPersistenceRemote {

	@Override
	public Professor inserir(Integer uid, Integer matricula, String nome, Academia academia) {
		Professor professor = new Professor();
		professor.setId(uid);
		professor.setMatricula(matricula);
		professor.setNome(nome);
		professor.setAcademia(academia);
		super.insert(professor);
		return professor;
	}

	@Override
	public Professor update(Integer uid, Integer matricula, String nome, Academia academia) {
		Professor professor = super.find(Professor.class, uid);
		professor.setId(uid);
		professor.setMatricula(matricula);
		professor.setNome(nome);
		professor.setAcademia(academia);
		super.update(professor);
		return professor;
	}

	@Override
	public Professor find(Integer uid) {
		return super.find(Professor.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Professor.class, uid);

	}

	@XmlElement(name = "professores")
	public List<Professor> findAll() {
		return  super.findAll(Professor.class);
	}

}
