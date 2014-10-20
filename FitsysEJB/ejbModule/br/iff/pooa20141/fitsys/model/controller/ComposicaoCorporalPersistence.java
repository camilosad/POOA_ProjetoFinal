package br.iff.pooa20141.fitsys.model.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.bind.annotation.XmlElement;

import br.iff.pooa20141.fitsys.model.entity.ComposicaoCorporal;

@Stateless
@LocalBean
public class ComposicaoCorporalPersistence extends AbstractPersistence implements
ComposicaoCorporalPersistenceRemote {

	@Override
	public ComposicaoCorporal inserir(Integer uid, float massa_total, float massa_magra, float massa_gorda, float massa_ossea, float altura) {
		ComposicaoCorporal composicao = new ComposicaoCorporal();
		composicao.setId(uid);
		composicao.setMassaTotal(massa_total);
		composicao.setMassaMagra(massa_magra);
		composicao.setMassaGorda(massa_gorda);
		composicao.setMassaOssea(massa_ossea);
		composicao.setAltura(altura);
		super.insert(composicao);
		return composicao;
	}

	@Override
	public ComposicaoCorporal update(Integer uid, float massa_total, float massa_magra, float massa_gorda, float massa_ossea, float altura) {
		ComposicaoCorporal composicao = super.find(ComposicaoCorporal.class, uid);
		composicao.setId(uid);
		composicao.setMassaTotal(massa_total);
		composicao.setMassaMagra(massa_magra);
		composicao.setMassaGorda(massa_gorda);
		composicao.setMassaOssea(massa_ossea);
		composicao.setAltura(altura);
		super.update(composicao);
		return composicao;
	}

	@Override
	public ComposicaoCorporal find(Integer uid) {
		return super.find(ComposicaoCorporal.class, uid);
	}

	@Override
	public void delete(Integer uid) {
		super.delete(ComposicaoCorporal.class, uid);

	}

	@XmlElement(name = "composicaocorporal")
	public List<ComposicaoCorporal> findAll() {
		return  super.findAll(ComposicaoCorporal.class);
	}

}
