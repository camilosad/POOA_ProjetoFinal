package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Academia;


@Remote
public interface AlunoPersistenceRemote {
	
	public Aluno inserir(Integer uid,  Integer matricula, String nome, String sexo, Academia academia);

	public Aluno update(Integer uid, Integer matricula, String nome, String sexo, Academia academia);

	public Aluno find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "aluno")
	public List<Aluno> findAll();

}
