package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;


public class ComposicaoCorporalTest {

	private ComposicaoCorporalPersistenceRemote composicaoPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		composicaoPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			composicaoPR = (ComposicaoCorporalPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/ComposicaoCorporalPersistence!br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistenceRemote");

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
		ComposicaoCorporal composicao = composicaoPR.inserir(1, 70, 20, 20, 30, 2);
		assertEquals(composicao.getId(), new Integer(1));
		composicaoPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		composicaoPR.inserir(1, 70, 20, 20, 30, 2);
		ComposicaoCorporal composicaoUP = composicaoPR.update(1, 75, 20, 20, 30, 2);

		assertEquals(composicaoUP.getMassaTotal(), 75.0, 1);
		composicaoPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		composicaoPR.inserir(1, 70, 20, 20, 30, 2);

		ComposicaoCorporal composicaoUp = composicaoPR.find(001);

		assertEquals(composicaoUp.getMassaTotal(), 70.0, 1);
		composicaoPR.delete(001);
	}

	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		composicaoPR.inserir(1, 70, 20, 20, 30, 2);

		composicaoPR.delete(001);
		assertEquals(composicaoPR.find(001), null);
	}

}
