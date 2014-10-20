package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import br.iff.pooa20141.fitsys.model.controller.AlunoPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AvaliacaoFisicaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.PerimetroPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.AvaliacaoFisica;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;
import br.iff.pooa20141.fitsys.model.entity.Academia;


public class AvaliacaoFisicaTest {

	private AcademiaPersistenceRemote academiaPR;
	private AlunoPersistenceRemote alunoPR;
	private ProfessorPersistenceRemote professorPR;
	private PerimetroPersistenceRemote perimetroPR;
	private ComposicaoCorporalPersistenceRemote composicaoPR;
	private AvaliacaoFisicaPersistenceRemote avaliacaoPR;
	Academia academia;
	Aluno aluno;
	Professor professor;
	Perimetro perimetro;
	ComposicaoCorporal composicao;
	//String uidSetor = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
		perimetroPR = null;
		composicaoPR = null;
		professorPR = null;
		alunoPR = null;
		academiaPR = null;
		avaliacaoPR = null;
		
		try {

			context = JNDILookupClass.getInitialContext();

			academiaPR = (AcademiaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			perimetroPR = (PerimetroPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/PerimetroPersistence!br.iff.pooa20141.fitsys.model.controller.PerimetroPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			composicaoPR = (ComposicaoCorporalPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ComposicaoCorporalPersistence!br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			professorPR = (ProfessorPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ProfessorPersistence!br.iff.pooa20141.fitsys.model.controller.ProfessorPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			alunoPR = (AlunoPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AlunoPersistence!br.iff.pooa20141.fitsys.model.controller.AlunoPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			avaliacaoPR = (AvaliacaoFisicaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AvaliacaoFisicaPersistence!br.iff.pooa20141.fitsys.model.controller.AvaliacaoFisicaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		//uidSetor = UUID.randomUUID().toString();
		academia = academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
		professor = professorPR.inserir(1, 123, "Joao", academia);
		aluno = alunoPR.inserir(1, 123, "Joao", "M", academia);
		composicao = composicaoPR.inserir(1, 70, 20, 20, 30, 2);
		perimetro = perimetroPR.inserir(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
	}

	@After
	public void tearDown() throws Exception {
		composicaoPR.delete(001);
		perimetroPR.delete(001);
		alunoPR.delete(001);
		professorPR.delete(001);
		academiaPR.delete(001);
	}

	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		Date data = new Date(2014, 10, 15);
		AvaliacaoFisica avaliacao = avaliacaoPR.inserir(1, data, "Observacao", aluno, professor, perimetro, composicao);
		assertEquals(avaliacao.getId(), new Integer(1));
		avaliacaoPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		Date data = new Date(2014, 10, 15);
		avaliacaoPR.inserir(1, data, "Observacao", aluno, professor, perimetro, composicao);
		AvaliacaoFisica avaliacaoUp = avaliacaoPR.update(1, data, "Obs", aluno, professor, perimetro, composicao);

		assertEquals(avaliacaoUp.getObservacoes(), "Obs");
		avaliacaoPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		Date data = new Date(2014, 10, 15);
		avaliacaoPR.inserir(1, data, "Observacao", aluno, professor, perimetro, composicao);

		AvaliacaoFisica avaliacaoUp = avaliacaoPR.find(001);

		assertEquals(avaliacaoUp.getObservacoes(), "Observacao");
		avaliacaoPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		Date data = new Date(2014, 10, 15);
		avaliacaoPR.inserir(1, data, "Observacao", aluno, professor, perimetro, composicao);

		avaliacaoPR.delete(001);
		assertEquals(avaliacaoPR.find(001), null);
	}


}