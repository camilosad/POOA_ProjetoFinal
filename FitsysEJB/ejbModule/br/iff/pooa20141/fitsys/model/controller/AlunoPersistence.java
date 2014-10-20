package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Aluno;
import br.iff.pooa20141.fitsys.model.entity.Academia;

@Stateless
@LocalBean
public class AlunoPersistence extends AbstractPersistence implements
		AlunoPersistenceRemote {

	@Override
	public Aluno inserir(Integer uid, Integer matricula, String nome,
			String sexo, Academia academia) {
		Aluno aluno = new Aluno();
		aluno.setId(uid);
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setSexo(sexo);
		aluno.setAcademia(academia);
		super.insert(aluno);
		return aluno;
	}

	@Override
	public Aluno update(Integer uid, Integer matricula, String nome,
			String sexo, Academia academia) {
		Aluno aluno = super.find(Aluno.class, uid);
		aluno.setId(uid);
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setSexo(sexo);
		aluno.setAcademia(academia);
		super.update(aluno);
		return aluno;
	}

	@Override
	public Aluno find(Integer uid) {
		return super.find(Aluno.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Aluno.class, uid);

	}

	@XmlElement(name = "academias")
	public List<Aluno> findAll() {
		return  super.findAll(Aluno.class);
	}

}
