package com.uca.capas.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(schema ="public", name = "contribuyente")
public class Contribuyente {
	
    @Id
    @Column(name = "c_contribuyente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContribuyente;

    @Column(name = "s_nombre")
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Size(message = "El nombre no debe tener mas de 30 caracteres", max = 30)
    private String nombre;

    @Column(name = "s_apellido")
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Size(message = "El apellido no debe tener mas de 30 caracteres", max = 30)
    private String apellido;

    @Column(name = "s_nit")
    @NotEmpty(message = "Este campo no puede estar vacio")
    @Size(message = "El NIT debe tener 14 digitos", min = 14, max = 14)
	@Pattern(regexp = "([0-9]*)$", message = "El NIT solo debe contener numeros")
    private String nit;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="f_fecha_ingreso")
    private Date fechaIngreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "c_importancia")
    private Importancia importancia;
    
    public Contribuyente() {
    	
    }

	public Integer getIdContribuyente() {
		return idContribuyente;
	}

	public void setIdContribuyente(Integer idContribuyente) {
		this.idContribuyente = idContribuyente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getFechaIngreso() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fechaIngreso);
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}
}