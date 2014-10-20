package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.ExercicioFicha;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;
import br.iff.pooa20141.fitsys.model.entity.Ficha;

@Stateless
@LocalBean
public class ExercicioFichaPersistence extends AbstractPersistence implements
ExercicioFichaPersistenceRemote {

	@Override
	public ExercicioFicha inserir(Integer uid, String intensidade, Exercicio exercicio, Ficha ficha) {
		ExercicioFicha exercicioFicha = new ExercicioFicha();
		exercicioFicha.setId(uid);
		exercicioFicha.setIntensidade(intensidade);
		exercicioFicha.setExercicio(exercicio);
		exercicioFicha.setFicha(ficha);
		super.insert(exercicioFicha);
		return exercicioFicha;
	}

	@Override
	public ExercicioFicha update(Integer uid, String intensidade, Exercicio exercicio, Ficha ficha) {
		ExercicioFicha exercicioFicha = super.find(ExercicioFicha.class, uid);
		exercicioFicha.setId(uid);
		exercicioFicha.setIntensidade(intensidade);
		exercicioFicha.setExercicio(exercicio);
		exercicioFicha.setFicha(ficha);
		super.update(exercicioFicha);
		return exercicioFicha;
	}

	@Override
	public ExercicioFicha find(Integer uid) {
		return super.find(ExercicioFicha.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(ExercicioFicha.class, uid);

	}

	@XmlElement(name = "exercicioficha")
	public List<ExercicioFicha> findAll() {
		return  super.findAll(ExercicioFicha.class);
	}

}
