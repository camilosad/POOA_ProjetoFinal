package br.iff.pooa20141fitsys.web.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence;
import br.iff.pooa20141.fitsys.model.entity.Academia;


@ManagedBean(name = "academiaPrime")
@SessionScoped
public class AcademiaWebController {
	
	@EJB(lookup = "java:app/FitsysWEB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence")
	private AcademiaPersistence jacademia;

	private Academia academia;
	private Academia academiaSelecionado = new Academia();

	public Academia getAcademia() {
		if (academia == null) {
			academia = new Academia();
		}
		return academia;
	}

	public List<Academia> getAllAcademia() {
		return jacademia.findAll();
	}

	public void salva() {

		if (jacademia.find(academia.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("academia Ja Cadastrado"));

		} else {
			jacademia.insert(academia);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jacademia.find(academiaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("academia não Existe"));

		} else {
			jacademia.delete(academiaSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Academia getAcademiaSelecionado() {

		return academiaSelecionado;
	}

	public void setAcademiaSelecionado(Academia academiaSelecionado) {
		this.academiaSelecionado = academiaSelecionado;

	}

	public void update() {

		if (jacademia.find(academiaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("academia não Existe"));

		} else {

			jacademia.update(academiaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public AcademiaWebController() {

	}

}
