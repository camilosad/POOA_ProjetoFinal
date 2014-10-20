package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistence;
//import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;
//import br.iff.pooa20141.fitsys.model.entity.Academia;

@ManagedBean(name = "composicaoCorporalPrime")
@SessionScoped
public class ComposicaoCorporalWebController {

	//@EJB(lookup = "java:app/FitsysWEB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence")
	//private AcademiaPersistence jacademia;

	@EJB(lookup = "java:app/FitsysWEB/ComposicaoCorporalPersistence!br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistence")
	private ComposicaoCorporalPersistence jcomposicaoCorporal;

	private ComposicaoCorporal composicaoCorporal;
	private ComposicaoCorporal composicaoCorporalSelecionado = new ComposicaoCorporal();

	public ComposicaoCorporal getComposicaoCorporal() {
		if (composicaoCorporal == null) {
			composicaoCorporal = new ComposicaoCorporal();
		}
		return composicaoCorporal;
	}

	public List<ComposicaoCorporal> getAllComposicaoCorporal() {
		return jcomposicaoCorporal.findAll();
	}


	public void salva() {
		
		if (jcomposicaoCorporal.find(composicaoCorporal.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("composicaoCorporal Ja Cadastrado"));

		} else {

			jcomposicaoCorporal.insert(composicaoCorporal);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jcomposicaoCorporal.find(composicaoCorporalSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("composicaoCorporal não Existe"));

		} else {
			jcomposicaoCorporal.delete(composicaoCorporalSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public ComposicaoCorporal getComposicaoCorporalSelecionado() {

		return composicaoCorporalSelecionado;
	}

	public void setComposicaoCorporalSelecionado(ComposicaoCorporal composicaoCorporalSelecionado) {
		this.composicaoCorporalSelecionado = composicaoCorporalSelecionado;

	}

	public void update() {

		
		if (jcomposicaoCorporal.find(composicaoCorporalSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("composicaoCorporal não Existe"));

		} else {

			jcomposicaoCorporal.update(composicaoCorporalSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ComposicaoCorporalWebController() {

	}

}