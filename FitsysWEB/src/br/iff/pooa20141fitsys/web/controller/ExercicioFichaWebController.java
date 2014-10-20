package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.ExercicioFichaPersistence;
import br.iff.pooa20141.fitsys.model.controller.ExercicioPersistence;
import br.iff.pooa20141.fitsys.model.controller.FichaPersistence;
import br.iff.pooa20141.fitsys.model.entity.ExercicioFicha;
import br.iff.pooa20141.fitsys.model.entity.Exercicio;
import br.iff.pooa20141.fitsys.model.entity.Ficha;


@ManagedBean(name = "exercicioFichaPrime")
@SessionScoped
public class ExercicioFichaWebController {

	@EJB(lookup = "java:app/FitsysWEB/ExercicioPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioPersistence")
	private ExercicioPersistence jexercicio;

	@EJB(lookup = "java:app/FitsysWEB/FichaPersistence!br.iff.pooa20141.fitsys.model.controller.FichaPersistence")
	private FichaPersistence jficha;

	@EJB(lookup = "java:app/FitsysWEB/ExercicioFichaPersistence!br.iff.pooa20141.fitsys.model.controller.ExercicioFichaPersistence")
	private ExercicioFichaPersistence jexercicioFicha;

	private ExercicioFicha exercicioFicha;
	private ExercicioFicha exercicioFichaSelecionado = new ExercicioFicha();

	public ExercicioFicha getExercicioFicha() {
		if (exercicioFicha == null) {
			exercicioFicha = new ExercicioFicha();
		}
		return exercicioFicha;
	}

	public List<ExercicioFicha> getAllExercicioFicha() {
		return jexercicioFicha.findAll();
	}

	public List<Exercicio> getAllExercicio() {
		return jexercicio.findAll();
	}

	public List<Ficha> getAllFicha() {
		return jficha.findAll();
	}

	public void salva() {
		
		if (jexercicioFicha.find(exercicioFicha.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicioFicha Ja Cadastrado"));

		} else {

			jexercicioFicha.insert(exercicioFicha);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jexercicioFicha.find(exercicioFichaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicioFicha não Existe"));

		} else {
			jexercicioFicha.delete(exercicioFichaSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public ExercicioFicha getExercicioFichaSelecionado() {

		return exercicioFichaSelecionado;
	}

	public void setExercicioFichaSelecionado(ExercicioFicha exercicioFichaSelecionado) {
		this.exercicioFichaSelecionado = exercicioFichaSelecionado;

	}

	public void update() {

		
		if (jexercicioFicha.find(exercicioFichaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("exercicioFicha não Existe"));

		} else {

			jexercicioFicha.update(exercicioFichaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public ExercicioFichaWebController() {

	}

}