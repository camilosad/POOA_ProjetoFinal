package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Exercicio;

@Remote
public interface ExercicioPersistenceRemote {
	
	public Exercicio inserir(Integer uid, String nome, String descricao);

	public Exercicio update(Integer uid, String nome, String descricao);

	public Exercicio find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "exercicio")
	public List<Exercicio> findAll();

}
