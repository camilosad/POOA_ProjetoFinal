package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.PerimetroPersistence;
//import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;
//import br.iff.pooa20141.fitsys.model.entity.Academia;

@ManagedBean(name = "perimetroPrime")
@SessionScoped
public class PerimetroWebController {

	//@EJB(lookup = "java:app/FitsysWEB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence")
	//private AcademiaPersistence jacademia;

	@EJB(lookup = "java:app/FitsysWEB/PerimetroPersistence!br.iff.pooa20141.fitsys.model.controller.PerimetroPersistence")
	private PerimetroPersistence jperimetro;

	private Perimetro perimetro;
	private Perimetro perimetroSelecionado = new Perimetro();

	public Perimetro getPerimetro() {
		if (perimetro == null) {
			perimetro = new Perimetro();
		}
		return perimetro;
	}

	public List<Perimetro> getAllPerimetro() {
		return jperimetro.findAll();
	}


	public void salva() {
		
		if (jperimetro.find(perimetro.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("perimetro Ja Cadastrado"));

		} else {

			jperimetro.insert(perimetro);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jperimetro.find(perimetroSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("perimetro não Existe"));

		} else {
			jperimetro.delete(perimetroSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Perimetro getPerimetroSelecionado() {

		return perimetroSelecionado;
	}

	public void setPerimetroSelecionado(Perimetro perimetroSelecionado) {
		this.perimetroSelecionado = perimetroSelecionado;

	}

	public void update() {

		
		if (jperimetro.find(perimetroSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("perimetro não Existe"));

		} else {

			jperimetro.update(perimetroSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public PerimetroWebController() {

	}

}