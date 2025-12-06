package com.economi.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

@Table("T_CATEGORIA")
public class Categoria {

    @Id
    @Column("id_categoria")
    private Integer idCategoria;

    @Column("nombre")
    private String nombre;

    @Column("tipo")
    private String tipo; // "gasto" o "ingreso"

    @Column("descripcion")
    private String descripcion;

    // Constructor vacío
    public Categoria() {}

    // Constructor completo
    public Categoria(Integer idCategoria, String nombre, String tipo, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    public Categoria( String nombre, String tipo, String descripcion) {

    	this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }


    // Getters y Setters
    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
