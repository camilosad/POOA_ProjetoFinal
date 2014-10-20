package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the composicao_corporal database table.
 * 
 */
@Entity
@Table(name="composicao_corporal")
@NamedQuery(name="ComposicaoCorporal.findAll", query="SELECT c FROM ComposicaoCorporal c")
public class ComposicaoCorporal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private float altura;

	@Column(name="massa_gorda")
	private float massaGorda;

	@Column(name="massa_magra")
	private float massaMagra;

	@Column(name="massa_ossea")
	private float massaOssea;

	@Column(name="massa_total")
	private float massaTotal;

	//bi-directional many-to-one association to AvaliacaoFisica
	@OneToMany(mappedBy="composicaoCorporal")
	private List<AvaliacaoFisica> avaliacaoFisicas;

	public ComposicaoCorporal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getAltura() {
		return this.altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getMassaGorda() {
		return this.massaGorda;
	}

	public void setMassaGorda(float massaGorda) {
		this.massaGorda = massaGorda;
	}

	public float getMassaMagra() {
		return this.massaMagra;
	}

	public void setMassaMagra(float massaMagra) {
		this.massaMagra = massaMagra;
	}

	public float getMassaOssea() {
		return this.massaOssea;
	}

	public void setMassaOssea(float massaOssea) {
		this.massaOssea = massaOssea;
	}

	public float getMassaTotal() {
		return this.massaTotal;
	}

	public void setMassaTotal(float massaTotal) {
		this.massaTotal = massaTotal;
	}

	public List<AvaliacaoFisica> getAvaliacaoFisicas() {
		return this.avaliacaoFisicas;
	}

	public void setAvaliacaoFisicas(List<AvaliacaoFisica> avaliacaoFisicas) {
		this.avaliacaoFisicas = avaliacaoFisicas;
	}

	public AvaliacaoFisica addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().add(avaliacaoFisica);
		avaliacaoFisica.setComposicaoCorporal(this);

		return avaliacaoFisica;
	}

	public AvaliacaoFisica removeAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().remove(avaliacaoFisica);
		avaliacaoFisica.setComposicaoCorporal(null);

		return avaliacaoFisica;
	}

}