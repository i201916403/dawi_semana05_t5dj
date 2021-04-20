package org.ciberfarma.modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table(name = "tb_categorias")
public class Categoria {
	
	@Id
	@Column(name = "idcategoria")
	private int id;

	@Column(name = "descripcion")
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
