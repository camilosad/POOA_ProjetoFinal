package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.ExercicioFicha;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;
import br.iff.pooa20141.fitsys.model.entity.Ficha;

@Remote
public interface ExercicioFichaPersistenceRemote {
	
	public ExercicioFicha inserir(Integer uid, String intensidade, Exercicio exercicio, Ficha ficha);

	public ExercicioFicha update(Integer uid, String intensidade, Exercicio exercicio, Ficha ficha);

	public ExercicioFicha find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "exercicioficha")
	public List<ExercicioFicha> findAll();

}
