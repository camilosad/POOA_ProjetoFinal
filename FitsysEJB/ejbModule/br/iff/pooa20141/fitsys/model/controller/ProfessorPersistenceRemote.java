package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;

@Remote
public interface ProfessorPersistenceRemote {
	
	public Professor inserir(Integer uid, Integer matricula, String nome, Academia academia);

	public Professor update(Integer uid, Integer matricula, String nome, Academia academia);

	public Professor find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "ficha")
	public List<Professor> findAll();
}
