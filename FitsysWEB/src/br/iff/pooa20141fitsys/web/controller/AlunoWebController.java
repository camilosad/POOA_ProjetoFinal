package br.iff.pooa20141fitsys.web.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.iff.pooa20141.fitsys.model.controller.AlunoPersistence;
import br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence;
import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Academia;

@ManagedBean(name = "alunoPrime")
@SessionScoped
public class AlunoWebController {

	@EJB(lookup = "java:app/FitsysWEB/AcademiaPersistence!br.iff.pooa20141.fitsys.model.controller.AcademiaPersistence")
	private AcademiaPersistence jacademia;

	@EJB(lookup = "java:app/FitsysWEB/AlunoPersistence!br.iff.pooa20141.fitsys.model.controller.AlunoPersistence")
	private AlunoPersistence jaluno;

	private Aluno aluno;
	private Aluno alunoSelecionado = new Aluno();

	public Aluno getAluno() {
		if (aluno == null) {
			aluno = new Aluno();
		}
		return aluno;
	}

	public List<Aluno> getAllAluno() {
		return jaluno.findAll();
	}

	public List<Academia> getAllAcademia() {
		return jacademia.findAll();
	}

	public void salva() {
		
		if (jaluno.find(aluno.getId()) != null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("aluno Ja Cadastrado"));

		} else {

			jaluno.insert(aluno);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Cadastrado com sucesso!"));
		}
		
		RequestContext.getCurrentInstance().execute("cadastro.hide()");
		;
		
	}

	public void delete() {

		if (jaluno.find(alunoSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("aluno não Existe"));

		} else {
			jaluno.delete(alunoSelecionado.getId());

		}
		RequestContext.getCurrentInstance().execute("deleta.hide()");
	}

	public Aluno getAlunoSelecionado() {

		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;

	}

	public void update() {

		
		if (jaluno.find(alunoSelecionado.getId()) == null) {
			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("aluno não Existe"));

		} else {

			jaluno.update(alunoSelecionado);

			FacesContext.getCurrentInstance().addMessage("frmTeste:msgOK",
					new FacesMessage("Alterado com sucesso!"));
		}
		RequestContext.getCurrentInstance().execute("altera.hide()");
		;
		
	}

	public AlunoWebController() {

	}

}