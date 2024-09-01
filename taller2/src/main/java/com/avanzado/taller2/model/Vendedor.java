package com.avanzado.taller2.model;

import java.util.Date;

public class Vendedor{
    private long id;
    private Integer valor;
    private Date fecha;
    private String vendedor;
    private String zona;
    private String token;
    public Vendedor() {
    }
    public Vendedor(long id, Integer valor, Date fecha, String vendedor, String zona, String token) {
        this.id = id;
        this.valor = valor;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.zona = zona;
        this.token = token;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getVendedor() {
        return vendedor;
    }
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    public String getZona() {
        return zona;
    }
    public void setZona(String zona) {
        this.zona = zona;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    @Override
    public String toString() {
        return "Vendedor [id=" + id + ", valor=" + valor + ", fecha=" + fecha + ", vendedor=" + vendedor + ", zona="
                + zona + ", token=" + token + "]";
    }
    
}
