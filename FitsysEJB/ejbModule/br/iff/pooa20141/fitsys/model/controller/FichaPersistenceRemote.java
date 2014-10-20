package br.iff.pooa20141.fitsys.model.controller;

import java.sql.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Ficha;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;

@Remote
public interface FichaPersistenceRemote {

	public Ficha inserir(Integer uid, Date data_criacao, Date data_validade, String dia_da_semana, String objetivo, Aluno aluno, Professor professor);

	public Ficha update(Integer uid, Date data_criacao, Date data_validade, String dia_da_semana, String objetivo, Aluno aluno, Professor professor);

	public Ficha find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "ficha")
	public List<Ficha> findAll();

}
