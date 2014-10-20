package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Academia;


@Remote
public interface AcademiaPersistenceRemote {

	public Academia inserir(Integer uid,  String cidade, String endereco, String nome);

	public Academia update(Integer uid, String cidade, String endereco, String nome);

	public Academia find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "academia")
	public List<Academia> findAll();

}