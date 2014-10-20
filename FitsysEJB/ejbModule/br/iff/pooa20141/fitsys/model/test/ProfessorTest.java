package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;


public class ProfessorTest {

	private AcademiaPersistenceRemote academiaPR;
	private ProfessorPersistenceRemote professorPR;
	Academia academia;
	//String uidSetor = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
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
		//uidSetor = UUID.randomUUID().toString();
		academia = academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
	}

	@After
	public void tearDown() throws Exception {
		academiaPR.delete(001);
	}

	@Test
	public void testInserir() {
		//String uid = UUID.randomUUID().toString();
		Professor professor = professorPR.inserir(1, 123, "Joao", academia);
		assertEquals(professor.getId(), new Integer(1));
		professorPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		professorPR.inserir(1, 123, "Joao", academia);
		Professor professorUp = professorPR.update(1, 123, "Jose", academia);;

		assertEquals(professorUp.getNome(), "Jose");
		professorPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		professorPR.inserir(1, 123, "Joao", academia);

		Professor professorUp = professorPR.find(001);

		assertEquals(professorUp.getNome(), "Joao");
		professorPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		professorPR.inserir(1, 123, "Joao", academia);

		professorPR.delete(001);
		assertEquals(professorPR.find(001), null);
	}


}