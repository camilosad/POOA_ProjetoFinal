package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.PerimetroPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;


public class PerimetroTest {

	private PerimetroPersistenceRemote perimetroPR;

	@Before
	public void setUp() throws Exception {
		Context context = null;
		perimetroPR = null;
		try {

			context = JNDILookupClass.getInitialContext();

			perimetroPR = (PerimetroPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/PerimetroPersistence!br.iff.pooa20141.fitsys.model.controller.PerimetroPersistenceRemote");

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
		float x = 2;
		Perimetro perimetro = perimetroPR.inserir(1, x, x, x, x, x, x, x, x, x, x, x, x);
		assertEquals(perimetro.getId(), new Integer(1));
		perimetroPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		float x = 2;
		perimetroPR.inserir(1, x, x, x, x, x, x, x, x, x, x, x, x);
		Perimetro perimetroUP = perimetroPR.update(1, 3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
		float y = 3;
		assertEquals(perimetroUP.getTorax(), y, 1);
		perimetroPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		float x = 2;
		perimetroPR.inserir(1, x, x, x, x, x, x, x, x, x, x, x, x);

		Perimetro perimetroUp = perimetroPR.find(001);
		assertEquals(perimetroUp.getTorax(), x, 1);
		perimetroPR.delete(001);
	}

	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		perimetroPR.inserir(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

		perimetroPR.delete(001);
		assertEquals(perimetroPR.find(001), null);
	}

}
