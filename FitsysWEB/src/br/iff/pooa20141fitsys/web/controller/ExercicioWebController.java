package br.iff.pooa20141fitsys.web.controller;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.ExercicioPersistence;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;


@ManagedBean(name = "exercicioPrime")
@SessionScoped
public class ExercicioWebController {
	
	@EJB(lookup = "java:app/FitsysWEB/ExercicioPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioPersistence")
	private ExercicioPersistence jexercicio;

	private Exercicio exercicio;
	private Exercicio exercicioSelecionado = new Exercicio();

	public Exercicio getExercicio() {
		if (exercicio == null) {
			exercicio = new Exercicio();
		}
		return exercicio;
	}

	public List<Exercicio> getAllExercicio() {
		return jexercicio.findAll();
	}

	public void salva() {

		if (jexercicio.find(exercicio.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicio Ja Cadastrado"));

		} else {
			jexercicio.insert(exercicio);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
	}

	public void delete() {

		if (jexercicio.find(exercicioSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicio não Existe"));

		} else {
			jexercicio.delete(exercicioSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Exercicio getExercicioSelecionado() {

		return exercicioSelecionado;
	}

	public void setExercicioSelecionado(Exercicio exercicioSelecionado) {
		this.exercicioSelecionado = exercicioSelecionado;

	}

	public void update() {

		if (jexercicio.find(exercicioSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicio não Existe"));

		} else {

			jexercicio.update(exercicioSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
	}

	public ExercicioWebController() {

	}

}
