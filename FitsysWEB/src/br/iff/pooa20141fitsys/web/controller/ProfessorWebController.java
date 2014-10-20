package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Academia;

@ManagedBean(name = "professorPrime")
@SessionScoped
public class ProfessorWebController {

	@EJB(lookup = "java:app/FitsysWEB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence")
	private AcademiaPersistence jacademia;

	@EJB(lookup = "java:app/FitsysWEB/ProfessorPersistence!br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence")
	private ProfessorPersistence jprofessor;

	private Professor professor;
	private Professor professorSelecionado = new Professor();

	public Professor getProfessor() {
		if (professor == null) {
			professor = new Professor();
		}
		return professor;
	}

	public List<Professor> getAllProfessor() {
		return jprofessor.findAll();
	}

	public List<Academia> getAllAcademia() {
		return jacademia.findAll();
	}

	public void salva() {
		
		if (jprofessor.find(professor.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("professor Ja Cadastrado"));

		} else {

			jprofessor.insert(professor);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jprofessor.find(professorSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("professor não Existe"));

		} else {
			jprofessor.delete(professorSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Professor getProfessorSelecionado() {

		return professorSelecionado;
	}

	public void setProfessorSelecionado(Professor professorSelecionado) {
		this.professorSelecionado = professorSelecionado;

	}

	public void update() {

		
		if (jprofessor.find(professorSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("professor não Existe"));

		} else {

			jprofessor.update(professorSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ProfessorWebController() {

	}

}