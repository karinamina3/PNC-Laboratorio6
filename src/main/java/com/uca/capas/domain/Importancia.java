package com.uca.capas.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "importancia")
public class Importancia {
	
    @Id
    @Column(name = "c_importancia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImportancia;

    @Column(name = "s_importancia")
    private String importancia;

    @OneToMany(mappedBy = "importancia", fetch = FetchType.EAGER)
    private List<Contribuyente> contribuyentes;

    public Importancia() {
    	
    }

	public Integer getIdImportancia() {
		return idImportancia;
	}

	public void setIdImportancia(Integer idImportancia) {
		this.idImportancia = idImportancia;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	public List<Contribuyente> getContribuyentes() {
		return contribuyentes;
	}

	public void setContribuyentes(List<Contribuyente> contribuyentes) {
		this.contribuyentes = contribuyentes;
	}
}
