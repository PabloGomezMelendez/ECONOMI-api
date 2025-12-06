
package com.economi.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("T_SIMULACIONES")
public class Simulacion {

    @Id
    @Column("id_simulacion")
    private Integer idSimulacion;

    @Column("user_id")
    private Integer userId; // Relación con T_USUARIO

    @Column("tipo")
    private String tipo; // "inversión" o "ahorro"

    @Column("parametros")
    private String parametros; // JSON o texto con parámetros de la simulación

    @Column("resultado")
    private BigDecimal resultado;

    @Column("fecha")
    private LocalDateTime fecha;

    // Constructor vacío
    public Simulacion() {}

    // Constructor completo
    public Simulacion(Integer idSimulacion, Integer userId, String tipo, String parametros, BigDecimal resultado, LocalDateTime fecha) {
        this.idSimulacion = idSimulacion;
        this.userId = userId;
        this.tipo = tipo;
        this.parametros = parametros;
        this.resultado = resultado;
        this.fecha = fecha;
    }
    
    public Simulacion( Integer userId, String tipo, String parametros, BigDecimal resultado, LocalDateTime fecha) {
        this.userId = userId;
        this.tipo = tipo;
        this.parametros = parametros;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Integer getIdSimulacion() {
        return idSimulacion;
    }

    public void setIdSimulacion(Integer idSimulacion) {
        this.idSimulacion = idSimulacion;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public BigDecimal getResultado() {
        return resultado;
    }

    public void setResultado(BigDecimal resultado) {
        this.resultado = resultado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
