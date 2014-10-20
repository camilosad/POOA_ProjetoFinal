package br.iff.pooa20141.fitsys.model.test;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import br.iff.pooa20141.fitsys.model.controller.AlunoPersistenceRemote;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistenceRemote;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Academia;


public class AlunoTest {

	private AcademiaPersistenceRemote academiaPR;
	private AlunoPersistenceRemote alunoPR;
	Academia academia;
	//String uidSetor = UUID.randomUUID().toString();

	@Before
	public void setUp() throws Exception {
		Context context = null;
		alunoPR = null;
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

			alunoPR = (AlunoPersistenceRemote) context
					.lookup("ejb:FitsysEAR/FitsysEJB/AlunoPersistence!br.iff.pooa20141.fitsys.model.controller.AlunoPersistenceRemote");

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
		Aluno aluno = alunoPR.inserir(1, 123, "Joao", "M", academia);
		assertEquals(aluno.getId(), new Integer(1));
		alunoPR.delete(001);
	}

	@Test
	public void testupdate() {
		//String uid = UUID.randomUUID().toString();
		alunoPR.inserir(1, 123, "Joao", "M", academia);
		Aluno alunoUp = alunoPR.update(1, 123, "Jose", "M", academia);

		assertEquals(alunoUp.getNome(), "Jose");
		alunoPR.delete(001);
	}

	@Test
	public void testfind() {
		//String uid = UUID.randomUUID().toString();
		alunoPR.inserir(1, 123, "Joao", "M", academia);

		Aluno alunoUp = alunoPR.find(001);

		assertEquals(alunoUp.getNome(), "Joao");
		alunoPR.delete(001);
	}
	
	@Test
	public void testdelete() {
		//String uid = UUID.randomUUID().toString();
		alunoPR.inserir(1, 123, "Joao", "M", academia);

		alunoPR.delete(001);
		assertEquals(alunoPR.find(001), null);
	}


}