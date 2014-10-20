package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.ExercicioPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;


public class ExercicioTest {

	private ExercicioPersistenceRemote exercicioPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		exercicioPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			exercicioPR = (ExercicioPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ExercicioPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioPersistenceRemote");

		} catch (NamingException e) {
			e.printStackTrace();

		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		Exercicio exercicio = exercicioPR.inserir(1, "Supino", "Trabalha o peitoral");
		assertEquals(exercicio.getId(), new Integer(1));
		exercicioPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		exercicioPR.inserir(1, "Supino", "Trabalha o peitoral");
		Exercicio exercicioUP = exercicioPR.update(1, "Supino Reto", "Trabalha o peitoral");

		assertEquals(exercicioUP.getNome(), "Supino Reto");
		exercicioPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		exercicioPR.inserir(1, "Supino", "Trabalha o peitoral");

		Exercicio exercicioUp = exercicioPR.find(001);

		assertEquals(exercicioUp.getNome(), "Supino");
		exercicioPR.delete(001);
	}

	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		exercicioPR.inserir(1, "Supino", "Trabalha o peitoral");

		exercicioPR.delete(001);
		assertEquals(exercicioPR.find(001), null);
	}

}
