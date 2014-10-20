package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Exercicio;

@Stateless
@LocalBean
public class ExercicioPersistence extends AbstractPersistence implements
		ExercicioPersistenceRemote {

	@Override
	public Exercicio inserir(Integer uid, String nome, String descricao) {
		Exercicio exercicio = new Exercicio();
		exercicio.setId(uid);
		exercicio.setNome(nome);
		exercicio.setDescricao(descricao);
		super.insert(exercicio);
		return exercicio;
	}

	@Override
	public Exercicio update(Integer uid, String nome, String descricao) {
		Exercicio exercicio = super.find(Exercicio.class, uid);
		exercicio.setId(uid);
		exercicio.setNome(nome);
		exercicio.setDescricao(descricao);
		super.update(exercicio);
		return exercicio;
	}

	@Override
	public Exercicio find(Integer uid) {
		return super.find(Exercicio.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Exercicio.class, uid);

	}

	@XmlElement(name = "exercicios")
	public List<Exercicio> findAll() {
		return  super.findAll(Exercicio.class);
	}

}
