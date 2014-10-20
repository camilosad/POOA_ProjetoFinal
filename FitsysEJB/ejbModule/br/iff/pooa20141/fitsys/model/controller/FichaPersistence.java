package br.iff.pooa20141.fitsys.model.controller;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Ficha;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;

@Stateless
@LocalBean
public class FichaPersistence extends AbstractPersistence implements
		FichaPersistenceRemote {

	@Override
	public Ficha inserir(Integer uid, Date data_criacao, Date data_validade, String dia_da_semana, String objetivo, Aluno aluno, Professor professor) {
		Ficha ficha = new Ficha();
		ficha.setId(uid);
		ficha.setDataCriacao(data_criacao);
		ficha.setDataValidade(data_validade);
		ficha.setDiaDaSemana(dia_da_semana);
		ficha.setObjetivo(objetivo);
		ficha.setAluno(aluno);
		ficha.setProfessor(professor);
		super.insert(ficha);
		return ficha;
	}

	@Override
	public Ficha update(Integer uid, Date data_criacao, Date data_validade, String dia_da_semana, String objetivo, Aluno aluno, Professor professor) {
		Ficha ficha = super.find(Ficha.class, uid);
		ficha.setId(uid);
		ficha.setDataCriacao(data_criacao);
		ficha.setDataValidade(data_validade);
		ficha.setDiaDaSemana(dia_da_semana);
		ficha.setObjetivo(objetivo);
		ficha.setAluno(aluno);
		ficha.setProfessor(professor);
		super.update(ficha);
		return ficha;
	}

	@Override
	public Ficha find(Integer uid) {
		return super.find(Ficha.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Ficha.class, uid);

	}

	@XmlElement(name = "fichas")
	public List<Ficha> findAll() {
		return  super.findAll(Ficha.class);
	}

}
