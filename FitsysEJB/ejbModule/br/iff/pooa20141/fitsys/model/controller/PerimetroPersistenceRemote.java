package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Perimetro;

@Remote
public interface PerimetroPersistenceRemote {
	
	public Perimetro inserir(Integer uid, float torax, float cintura, float abdomen, float quadril, float antebraco_D, float antebraco_E, float braco_D, float braco_E, float coxa_D,  float coxa_E, float panturrilha_D, float panturrilha_E);

	public Perimetro update(Integer uid, float torax, float cintura, float abdomen, float quadril, float antebraco_D, float antebraco_E, float braco_D, float braco_E, float coxa_D,  float coxa_E, float panturrilha_D, float panturrilha_E);

	public Perimetro find(Integer uid);

	public void delete(Integer uid);

	@XmlElement(name = "ficha")
	public List<Perimetro> findAll();
}
