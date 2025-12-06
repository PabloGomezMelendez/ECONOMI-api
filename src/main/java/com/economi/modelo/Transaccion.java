
package com.economi.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("T_TRANSACCIONES")
public class Transaccion {

    @Id
    @Column("id_transaccion")
    private Integer idTransaccion;

    @Column("id_usuario")
    private Integer idUsuario; // Relación con T_USUARIO

    @Column("id_categoria")
    private Integer idCategoria; // Relación con T_CATEGORIA

    @Column("cantidad")
    private BigDecimal cantidad;

    @Column("fecha")
    private LocalDate fecha;

    @Column("tipo")
    private String tipo; // "gasto" o "ingreso"

    @Column("descripcion")
    private String descripcion;

    // Constructor vacío
    public Transaccion() {}

    // Constructor completo
    public Transaccion(Integer idTransaccion, Integer idUsuario, Integer idCategoria, BigDecimal cantidad, LocalDate fecha, String tipo, String descripcion) {
        this.idTransaccion = idTransaccion;
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    public Transaccion( Integer idUsuario, Integer idCategoria, BigDecimal cantidad, LocalDate fecha, String tipo, String descripcion) {
        this.idUsuario = idUsuario;
        this.idCategoria = idCategoria;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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
