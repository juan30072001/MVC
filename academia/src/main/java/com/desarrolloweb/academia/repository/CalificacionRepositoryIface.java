package com.desarrolloweb.academia.repository;

import java.util.List;

import com.desarrolloweb.academia.model.Calificacion;

public interface CalificacionRepositoryIface {

    public List<Calificacion> obtenerTodos(); // si termina en ; se le llama firma o contratos
    public void guardar(Calificacion calificacion); //
    
}
