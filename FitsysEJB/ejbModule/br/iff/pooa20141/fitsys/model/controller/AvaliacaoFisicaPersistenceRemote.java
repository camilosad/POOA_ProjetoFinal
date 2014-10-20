package br.iff.pooa20141.fitsys.model.controller;


import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.AvaliacaoFisica;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;


@Remote
public interface AvaliacaoFisicaPersistenceRemote {
	
	public AvaliacaoFisica inserir(Integer uid,  Date data, String obs, Aluno aluno, Professor professor, Perimetro perimetros, ComposicaoCorporal composicao);

	public AvaliacaoFisica update(Integer uid, Date data, String obs, Aluno aluno, Professor professor, Perimetro perimetros, ComposicaoCorporal composicao);

	public AvaliacaoFisica find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "avaliacaofisica")
	public List<AvaliacaoFisica> findAll();
}
