package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.Perimetro;

@Stateless
@LocalBean
public class PerimetroPersistence extends AbstractPersistence implements
		PerimetroPersistenceRemote {

	@Override
	public Perimetro inserir(Integer uid, float torax, float cintura, float abdomen, float quadril, float antebraco_D, float antebraco_E, float braco_D, float braco_E, float coxa_D,  float coxa_E, float panturrilha_D, float panturrilha_E) {
		Perimetro perimetro = new Perimetro();
		perimetro.setId(uid);
		perimetro.setTorax(torax);
		perimetro.setCintura(cintura);
		perimetro.setAbdomen(abdomen);
		perimetro.setAntebracoDireito(antebraco_D);
		perimetro.setAntebracoEsquerdo(antebraco_E);
		perimetro.setBracoDireito(braco_D);
		perimetro.setBracoEsquerdo(braco_E);
		perimetro.setCoxaDireita(coxa_D);
		perimetro.setCoxaEsquerda(coxa_E);
		perimetro.setPanturrilhaDireita(panturrilha_D);
		perimetro.setPanturrilhaEsquerda(panturrilha_E);
		super.insert(perimetro);
		return perimetro;
	}

	@Override
	public Perimetro update(Integer uid, float torax, float cintura, float abdomen, float quadril, float antebraco_D, float antebraco_E, float braco_D, float braco_E, float coxa_D,  float coxa_E, float panturrilha_D, float panturrilha_E) {
		Perimetro perimetro = super.find(Perimetro.class, uid);
		perimetro.setId(uid);
		perimetro.setTorax(torax);
		perimetro.setCintura(cintura);
		perimetro.setAbdomen(abdomen);
		perimetro.setAntebracoDireito(antebraco_D);
		perimetro.setAntebracoEsquerdo(antebraco_E);
		perimetro.setBracoDireito(braco_D);
		perimetro.setBracoEsquerdo(braco_E);
		perimetro.setCoxaDireita(coxa_D);
		perimetro.setCoxaEsquerda(coxa_E);
		perimetro.setPanturrilhaDireita(panturrilha_D);
		perimetro.setPanturrilhaEsquerda(panturrilha_E);
		super.update(perimetro);
		return perimetro;
	}

	@Override
	public Perimetro find(Integer uid) {
		return super.find(Perimetro.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(Perimetro.class, uid);

	}

	@XmlElement(name = "perimetros")
	public List<Perimetro> findAll() {
		return  super.findAll(Perimetro.class);
	}

}
