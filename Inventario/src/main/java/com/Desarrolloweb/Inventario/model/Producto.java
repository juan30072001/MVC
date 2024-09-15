package com.Desarrolloweb.Inventario.model;

import java.sql.Date;

public class Producto {
    Long id;
    String descripcion;
    String categoria;
    Integer existencia;
    Integer precio;
    Date ultimoIngreso;
    Boolean disponible;
    String observacion;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Integer getExistencia() {
        return existencia;
    }
    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    public Integer getPrecio() {
        return precio;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public Date getUltimoIngreso() {
        return ultimoIngreso;
    }
    public void setUltimoIngreso(Date ultimoIngreso) {
        this.ultimoIngreso = ultimoIngreso;
    }
    public Boolean getDisponible() {
        return disponible;
    }
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Producto() {
    }
    public Producto(Long id, String descripcion, String categoria, Integer existencia, Integer precio,
            Date ultimoIngreso, Boolean disponible, String observacion) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.existencia = existencia;
        this.precio = precio;
        this.ultimoIngreso = ultimoIngreso;
        this.disponible = disponible;
        this.observacion = observacion;
    }
    

}
