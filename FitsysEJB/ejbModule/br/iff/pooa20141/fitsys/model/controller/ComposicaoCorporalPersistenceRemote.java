package br.iff.pooa20141.fitsys.model.controller;


import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;

@Remote
public interface ComposicaoCorporalPersistenceRemote {

	public ComposicaoCorporal inserir(Integer uid,  float massa_total, float massa_magra, float massa_gorda, float massa_ossea, float altura);

	public ComposicaoCorporal update(Integer uid,  float massa_total, float massa_magra, float massa_gorda, float massa_ossea, float altura);

	public ComposicaoCorporal find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "composicaocorporal")
	public List<ComposicaoCorporal> findAll();
}
