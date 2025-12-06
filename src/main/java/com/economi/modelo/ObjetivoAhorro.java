
package com.economi.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table("T_OBJETIVOS_AHORRO")
public class ObjetivoAhorro {

    @Id
    @Column("id_objetivo")
    private Integer idObjetivo;

    @Column("user_id")
    private Integer userId; // Relación con T_USUARIO

    @Column("nombre")
    private String nombre;

    @Column("monto_objetivo")
    private BigDecimal montoObjetivo;

    @Column("fecha_limite")
    private LocalDate fechaLimite;

    @Column("estado")
    private String estado; // "pendiente" o "completado"

    // Constructor vacío
    public ObjetivoAhorro() {}

    // Constructor completo
    public ObjetivoAhorro(Integer idObjetivo, Integer userId, String nombre, BigDecimal montoObjetivo, LocalDate fechaLimite, String estado) {
        this.idObjetivo = idObjetivo;
        this.userId = userId;
        this.nombre = nombre;
        this.montoObjetivo = montoObjetivo;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
    }
    
    public ObjetivoAhorro( Integer userId, String nombre, BigDecimal montoObjetivo, LocalDate fechaLimite, String estado) {
        this.userId = userId;
        this.nombre = nombre;
        this.montoObjetivo = montoObjetivo;
        this.fechaLimite = fechaLimite;
        this.estado = estado;
    }

    // Getters y Setters
    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getMontoObjetivo() {
        return montoObjetivo;
    }

    public void setMontoObjetivo(BigDecimal montoObjetivo) {
        this.montoObjetivo = montoObjetivo;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
