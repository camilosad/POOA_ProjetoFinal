package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import br.iff.pooa20141.fitsys.model.controller.FichaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AlunoPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Ficha;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;



public class FichaTest {

	private FichaPersistenceRemote fichaPR;
	private AlunoPersistenceRemote alunoPR;
	private ProfessorPersistenceRemote professorPR;
	private AcademiaPersistenceRemote academiaPR;
	Professor professor;
	Aluno aluno;
	Academia academia;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		fichaPR = null;
		alunoPR = null;
		professorPR = null;
		academiaPR = null;
		

		try {

			context = JNDILookupClass.getInitialContext();

			academiaPR = (AcademiaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote");

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

			fichaPR = (FichaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/FichaPersistence!br.iff.pooa20141.fitsys.model.controller.FichaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		//uidSetor = UUID.randomUUID().toString();
		academia = academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
		aluno = alunoPR.inserir(1, 123, "Aluno1", "M", academia);
		professor = professorPR.inserir(1, 123, "Professor1", academia);
	}

	@After
	public void tearDown() throws Exception {
		alunoPR.delete(001);
		professorPR.delete(001);
		academiaPR.delete(001);
	}

	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		Date criacao = new Date(2014, 10, 30);
		Date validade = new Date(2014, 12, 30);
		
		Ficha ficha = fichaPR.inserir(1, criacao, validade, "Quinta-feira", "Emagrecimento", aluno, professor);
		
		assertEquals(ficha.getId(), new Integer(1));
		fichaPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		Date criacao = new Date(2014, 10, 30);
		Date validade = new Date(2014, 12, 30);
		fichaPR.inserir(1, criacao, validade, "Quinta-feira", "Emagrecimento", aluno, professor);
		
		Ficha fichaUp = fichaPR.update(1, criacao, validade, "Quinta-feira", "Ganho de massa", aluno, professor);

		assertEquals(fichaUp.getObjetivo(), "Ganho de massa");
		fichaPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		Date criacao = new Date(2014, 10, 30);
		Date validade = new Date(2014, 12, 30);
		fichaPR.inserir(1, criacao, validade, "Quinta-feira", "Emagrecimento", aluno, professor);

		Ficha fichaUp = fichaPR.find(001);

		assertEquals(fichaUp.getObjetivo(), "Emagrecimento");
		fichaPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		Date criacao = new Date(2014, 10, 30);
		Date validade = new Date(2014, 12, 30);
		fichaPR.inserir(1, criacao, validade, "Quinta-feira", "Emagrecimento", aluno, professor);

		fichaPR.delete(001);
		assertEquals(fichaPR.find(001), null);
	}

}