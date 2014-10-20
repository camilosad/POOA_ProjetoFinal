package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.AvaliacaoFisicaPersistence;
import br.iff.pooa20141.fitsys.model.controller.AlunoPersistence;
import br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence;
import br.iff.pooa20141.fitsys.model.controller.PerimetroPersistence;
import br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistence;
import br.iff.pooa20141.fitsys.model.entity.AvaliacaoFisica;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Professor;
import br.iff.pooa20141.fitsys.model.entity.Perimetro;
import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;

@ManagedBean(name = "avaliacaoFisicaPrime")
@SessionScoped
public class AvaliacaoFisicaWebController {

	@EJB(lookup = "java:app/FitsysWEB/AlunoPersistence!br.iff.pooa20141.fitsys.model.controller.AlunoPersistence")
	private AlunoPersistence jaluno;

	@EJB(lookup = "java:app/FitsysWEB/ProfessorPersistence!br.iff.pooa20141.fitsys.model.controller.ProfessorPersistence")
	private ProfessorPersistence jprofessor;

	@EJB(lookup = "java:app/FitsysWEB/PerimetroPersistence!br.iff.pooa20141.fitsys.model.controller.PerimetroPersistence")
	private PerimetroPersistence jperimetro;

	@EJB(lookup = "java:app/FitsysWEB/ComposicaoCorporalPersistence!br.iff.pooa20141.fitsys.model.controller.ComposicaoCorporalPersistence")
	private ComposicaoCorporalPersistence jcomposicaoCorporal;

	@EJB(lookup = "java:app/FitsysWEB/AvaliacaoFisicaPersistence!br.iff.pooa20141.fitsys.model.controller.AvaliacaoFisicaPersistence")
	private AvaliacaoFisicaPersistence javaliacaoFisica;

	private AvaliacaoFisica avaliacaoFisica;
	private AvaliacaoFisica avaliacaoFisicaSelecionado = new AvaliacaoFisica();

	public AvaliacaoFisica getAvaliacaoFisica() {
		if (avaliacaoFisica == null) {
			avaliacaoFisica = new AvaliacaoFisica();
		}
		return avaliacaoFisica;
	}

	public List<AvaliacaoFisica> getAllAvaliacaoFisica() {
		return javaliacaoFisica.findAll();
	}

	public List<Aluno> getAllAluno() {
		return jaluno.findAll();
	}

	public List<Professor> getAllProfessor() {
		return jprofessor.findAll();
	}

	public List<Perimetro> getAllPerimetro() {
		return jperimetro.findAll();
	}

	public List<ComposicaoCorporal> getAllComposicaoCorporal() {
		return jcomposicaoCorporal.findAll();
	}

	public void salva() {
		
		if (javaliacaoFisica.find(avaliacaoFisica.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("avaliacaoFisica Ja Cadastrado"));

		} else {

			javaliacaoFisica.insert(avaliacaoFisica);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (javaliacaoFisica.find(avaliacaoFisicaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("avaliacaoFisica não Existe"));

		} else {
			javaliacaoFisica.delete(avaliacaoFisicaSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public AvaliacaoFisica getAvaliacaoFisicaSelecionado() {

		return avaliacaoFisicaSelecionado;
	}

	public void setAvaliacaoFisicaSelecionado(AvaliacaoFisica avaliacaoFisicaSelecionado) {
		this.avaliacaoFisicaSelecionado = avaliacaoFisicaSelecionado;

	}

	public void update() {

		
		if (javaliacaoFisica.find(avaliacaoFisicaSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("avaliacaoFisica não Existe"));

		} else {

			javaliacaoFisica.update(avaliacaoFisicaSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public AvaliacaoFisicaWebController() {

	}

}