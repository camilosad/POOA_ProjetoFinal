package br.iff.pooa20141.fitsys.model.controller;

import java.sql.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.AvaliacaoFisica;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;


@Stateless
@LocalBean
public class AvaliacaoFisicaPersistence extends AbstractPersistence implements
		AvaliacaoFisicaPersistenceRemote {

	@Override
	public AvaliacaoFisica inserir(Integer uid, Date data, String obs, Aluno aluno, Professor professor, Perimetro perimetro, ComposicaoCorporal composicao) {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		avaliacao.setId(uid);
		avaliacao.setData(data);
		avaliacao.setObservacoes(obs);
		avaliacao.setAluno(aluno);
		avaliacao.setProfessor(professor);
		avaliacao.setComposicaoCorporal(composicao);
		avaliacao.setPerimetro(perimetro);
		super.insert(avaliacao);
		return avaliacao;
	}

	@Override
	public AvaliacaoFisica update(Integer uid, Date data, String obs, Aluno aluno, Professor professor, Perimetro perimetro, ComposicaoCorporal composicao) {
		AvaliacaoFisica avaliacao = super.find(AvaliacaoFisica.class, uid);
		avaliacao.setId(uid);
		avaliacao.setData(data);
		avaliacao.setObservacoes(obs);
		avaliacao.setAluno(aluno);
		avaliacao.setProfessor(professor);
		avaliacao.setComposicaoCorporal(composicao);
		avaliacao.setPerimetro(perimetro);
		super.update(avaliacao);
		return avaliacao;
	}

	@Override
	public AvaliacaoFisica find(Integer uid) {
		return super.find(AvaliacaoFisica.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(AvaliacaoFisica.class, uid);

	}

	@XmlElement(name = "academias")
	public List<AvaliacaoFisica> findAll() {
		return  super.findAll(AvaliacaoFisica.class);
	}

}
