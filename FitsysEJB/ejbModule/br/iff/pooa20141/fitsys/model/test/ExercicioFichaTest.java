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
import br.iff.pooa20141.fitsys.model.controller.ExercicioFichaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.ExercicioPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Ficha;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;
import br.iff.pooa20141.fitsys.model.entity.ExercicioFicha;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;



public class ExercicioFichaTest {

	private FichaPersistenceRemote fichaPR;
	private AlunoPersistenceRemote alunoPR;
	private ProfessorPersistenceRemote professorPR;
	private AcademiaPersistenceRemote academiaPR;
	private ExercicioPersistenceRemote exercicioPR;
	private ExercicioFichaPersistenceRemote exerciciofichaPR;
	Professor professor;
	Aluno aluno;
	Academia academia;
	Ficha ficha;
	Exercicio exercicio;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		exerciciofichaPR = null;
		exercicioPR = null;
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

		try {

			context = JNDILookupClass.getInitialContext();

			exercicioPR = (ExercicioPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ExercicioPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}

		try {

			context = JNDILookupClass.getInitialContext();

			exerciciofichaPR = (ExercicioFichaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ExercicioFichaPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioFichaPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
		
		

		//uidSetor = UUID.randomUUID().toString();
		Date criacao = new Date(2014, 10, 30);
		Date validade = new Date(2014, 12, 30);
		academia = academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
		aluno = alunoPR.inserir(1, 123, "Aluno1", "M", academia);
		professor = professorPR.inserir(1, 123, "Professor1", academia);
		ficha = fichaPR.inserir(1, criacao, validade, "Quinta-feira", "Emagrecimento", aluno, professor);
		exercicio = exercicioPR.inserir(1, "Supino", "Trabalha o peitoral");
	}

	@After
	public void tearDown() throws Exception {
		exercicioPR.delete(001);
		fichaPR.delete(001);
		alunoPR.delete(001);
		professorPR.delete(001);
		academiaPR.delete(001);
	}

	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		
		ExercicioFicha exercicioficha = exerciciofichaPR.inserir(1, "3 x 10", exercicio, ficha);
		
		assertEquals(exercicioficha.getId(), new Integer(1));
		exerciciofichaPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		exerciciofichaPR.inserir(1, "3 x 10", exercicio, ficha);
		
		ExercicioFicha exerciciofichaUp = exerciciofichaPR.update(1, "3 x 15", exercicio, ficha);

		assertEquals(exerciciofichaUp.getIntensidade(), "3 x 15");
		exerciciofichaPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		exerciciofichaPR.inserir(1, "3 x 10", exercicio, ficha);

		ExercicioFicha exerciciofichaUp = exerciciofichaPR.find(001);

		assertEquals(exerciciofichaUp.getIntensidade(), "3 x 10");
		exerciciofichaPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		exerciciofichaPR.inserir(1, "3 x 10", exercicio, ficha);

		exerciciofichaPR.delete(001);
		assertEquals(exerciciofichaPR.find(001), null);
	}

}