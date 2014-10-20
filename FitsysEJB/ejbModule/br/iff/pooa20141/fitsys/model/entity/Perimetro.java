package br.iff.pooa20141.fitsys.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perimetros database table.
 * 
 */
@Entity
@Table(name="perimetros")
@NamedQuery(name="Perimetro.findAll", query="SELECT p FROM Perimetro p")
public class Perimetro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private float abdomen;

	@Column(name="antebraco_direito")
	private float antebracoDireito;

	@Column(name="antebraco_esquerdo")
	private float antebracoEsquerdo;

	@Column(name="braco_direito")
	private float bracoDireito;

	@Column(name="braco_esquerdo")
	private float bracoEsquerdo;

	private float cintura;

	@Column(name="coxa_direita")
	private float coxaDireita;

	@Column(name="coxa_esquerda")
	private float coxaEsquerda;

	@Column(name="panturrilha_direita")
	private float panturrilhaDireita;

	@Column(name="panturrilha_esquerda")
	private float panturrilhaEsquerda;

	private float torax;

	//bi-directional many-to-one association to AvaliacaoFisica
	@OneToMany(mappedBy="perimetro")
	private List<AvaliacaoFisica> avaliacaoFisicas;

	public Perimetro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getAbdomen() {
		return this.abdomen;
	}

	public void setAbdomen(float abdomen) {
		this.abdomen = abdomen;
	}

	public float getAntebracoDireito() {
		return this.antebracoDireito;
	}

	public void setAntebracoDireito(float antebracoDireito) {
		this.antebracoDireito = antebracoDireito;
	}

	public float getAntebracoEsquerdo() {
		return this.antebracoEsquerdo;
	}

	public void setAntebracoEsquerdo(float antebracoEsquerdo) {
		this.antebracoEsquerdo = antebracoEsquerdo;
	}

	public float getBracoDireito() {
		return this.bracoDireito;
	}

	public void setBracoDireito(float bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public float getBracoEsquerdo() {
		return this.bracoEsquerdo;
	}

	public void setBracoEsquerdo(float bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public float getCintura() {
		return this.cintura;
	}

	public void setCintura(float cintura) {
		this.cintura = cintura;
	}

	public float getCoxaDireita() {
		return this.coxaDireita;
	}

	public void setCoxaDireita(float coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	public float getCoxaEsquerda() {
		return this.coxaEsquerda;
	}

	public void setCoxaEsquerda(float coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	public float getPanturrilhaDireita() {
		return this.panturrilhaDireita;
	}

	public void setPanturrilhaDireita(float panturrilhaDireita) {
		this.panturrilhaDireita = panturrilhaDireita;
	}

	public float getPanturrilhaEsquerda() {
		return this.panturrilhaEsquerda;
	}

	public void setPanturrilhaEsquerda(float panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}

	public float getTorax() {
		return this.torax;
	}

	public void setTorax(float torax) {
		this.torax = torax;
	}

	public List<AvaliacaoFisica> getAvaliacaoFisicas() {
		return this.avaliacaoFisicas;
	}

	public void setAvaliacaoFisicas(List<AvaliacaoFisica> avaliacaoFisicas) {
		this.avaliacaoFisicas = avaliacaoFisicas;
	}

	public AvaliacaoFisica addAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().add(avaliacaoFisica);
		avaliacaoFisica.setPerimetro(this);

		return avaliacaoFisica;
	}

	public AvaliacaoFisica removeAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
		getAvaliacaoFisicas().remove(avaliacaoFisica);
		avaliacaoFisica.setPerimetro(null);

		return avaliacaoFisica;
	}

}