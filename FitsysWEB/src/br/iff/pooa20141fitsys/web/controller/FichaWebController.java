package br.iff.pooa20141fitsys.web.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.AlunoPersistence;
import br.iff.pooa20141.fitsys.model.controller.FichaPersistence;
import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence;
import br.iff.pooa20141.fitsys.model.entity.Ficha;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;


@ManagedBean(name = "fichaPrime")
@SessionScoped
public class FichaWebController {
	
	@EJB(lookup = "java:app/FitsysWEB/AlunoPersistence!br.iff.pooa20141.fitsys.model.controller.AlunoPersistence")
	private AlunoPersistence jaluno;

	@EJB(lookup = "java:app/FitsysWEB/ProfessorPersistence!br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence")
	private ProfessorPersistence jprofessor;
	
	@EJB(lookup = "java:app/FitsysWEB/FichaPersistence!br.iff.pooa20141.fitsys.model.controller.FichaPersistence")
	private FichaPersistence jficha;

	private Ficha ficha;
	private Ficha fichaSelecionado = new Ficha();

	public Ficha getFicha() {
		if (ficha == null) {
			ficha = new Ficha();
		}
		return ficha;
	}

	public List<Ficha> getAllFicha() {
		return jficha.findAll();
	}
	
	public List<Aluno> getAllAluno() {
		return jaluno.findAll();
	}

	public List<Professor> getAllProfessor() {
		return jprofessor.findAll();
	}

	public void salva() {

		if (jficha.find(ficha.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("ficha Ja Cadastrado"));

		} else {
			jficha.insert(ficha);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jficha.find(fichaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("ficha não Existe"));

		} else {
			jficha.delete(fichaSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Ficha getFichaSelecionado() {

		return fichaSelecionado;
	}

	public void setFichaSelecionado(Ficha fichaSelecionado) {
		this.fichaSelecionado = fichaSelecionado;

	}

	public void update() {

		if (jficha.find(fichaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("ficha não Existe"));

		} else {

			jficha.update(fichaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public FichaWebController() {

	}

}
