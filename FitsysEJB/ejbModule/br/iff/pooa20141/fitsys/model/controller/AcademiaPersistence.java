package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Academia;

@Stateless
@LocalBean
public class AcademiaPersistence extends AbstractPersistence implements
		AcademiaPersistenceRemote {

	@Override
	public Academia inserir(Integer uid, String cidade, String endereco,
			String nome) {
		Academia academia = new Academia();
		academia.setId(uid);
		academia.setNome(nome);
		academia.setCidade(cidade);
		super.insert(academia);
		return academia;
	}

	@Override
	public Academia update(Integer uid, String cidade, String endereco,
			String nome) {
		Academia academia = super.find(Academia.class, uid);
		academia.setId(uid);
		academia.setNome(nome);
		academia.setCidade(cidade);
		super.update(academia);
		return academia;
	}

	@Override
	public Academia find(Integer uid) {
		return super.find(Academia.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Academia.class, uid);

	}

	@XmlElement(name = "academias")
	public List<Academia> findAll() {
		return  super.findAll(Academia.class);
	}

}
