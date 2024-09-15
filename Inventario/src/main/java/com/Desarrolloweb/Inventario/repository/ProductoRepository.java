package com.Desarrolloweb.Inventario.repository;

import com.Desarrolloweb.Inventario.model.Producto;
import java.util.List;
import java.util.ArrayList;
import java.security.SecureRandom;

public class ProductoRepository implements ProductoRepositoryIface {

    private List<Producto> productos = new ArrayList<>();
    private SecureRandom random = new SecureRandom();

    @Override
    public void guardar(Producto producto) {
        if(producto.getId()==null){
            producto.setId(random.nextInt(9000)+1000L);
            productos.add(producto);
        }else{
            boolean encontrado = false;
            for (int i=0; i<productos.size(); i++){
                Producto produc = productos.get(i);
                if(produc.getId().equals(producto.getId())){
                    productos.set(i, producto);
                    System.out.println("Producto actualizado con ID: " + producto.getId());
                    encontrado=true;
                    break;
                }
            }
            if (!encontrado) {
                productos.add(producto);
            }
        }
    }

    @Override
    public List<Producto> mostrar() {
        return productos;
    }

    @Override
    public void eliminar(Long id) {
        for (int i=0; i<productos.size(); i++){
            Producto pro = productos.get(i);
            if(pro.getId().equals(id)){
                productos.remove(i);
            }
        }
    }

    @Override
    public Producto obtener(Long id) {
        Producto producto = null;
        for (Producto pro:productos){
            if(id.equals(pro.getId())){
                producto = pro;
                break;
            }
        }
        return producto;
    }

}
