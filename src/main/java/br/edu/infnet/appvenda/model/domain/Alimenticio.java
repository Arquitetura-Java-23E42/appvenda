package br.edu.infnet.appvenda.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TAlimenticio")
public class Alimenticio extends Produto {

	private boolean organico;
	private String caracteristica;

	@Override
	public String toString() {
		return String.format("%s - %s - %s", super.toString(), organico, caracteristica);
	}
	
	public boolean isOrganico() {
		return organico;
	}
	public void setOrganico(boolean organico) {
		this.organico = organico;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
}