package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Academia;


public class AcademiaTest {

	private AcademiaPersistenceRemote academiaPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		academiaPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			academiaPR = (AcademiaPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote");

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
		Academia academia = academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
		assertEquals(academia.getId(), new Integer(1));
		academiaPR.delete(1);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");
		Academia academiaUP = academiaPR.update(1, "Goyta", "Rua do iff", "Fit");

		assertEquals(academiaUP.getCidade(), "Goyta");
		academiaPR.delete(1);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");

		Academia academiaUp = academiaPR.find(001);

		assertEquals(academiaUp.getNome(), "Fit");
		academiaPR.delete(1);
	}

	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		academiaPR.inserir(1, "Campos", "Rua do iff", "Fit");

		academiaPR.delete(1);
		assertEquals(academiaPR.find(1), null);
	}

}
