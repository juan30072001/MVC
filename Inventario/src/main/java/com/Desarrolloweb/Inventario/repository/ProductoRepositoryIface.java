package com.Desarrolloweb.Inventario.repository;


import com.Desarrolloweb.Inventario.model.Producto;
import java.util.List;

public interface ProductoRepositoryIface {
    public List<Producto> mostrar();
    public void guardar(Producto producto);
    public void eliminar(Long id);
    public Producto obtener(Long id);
    
}
