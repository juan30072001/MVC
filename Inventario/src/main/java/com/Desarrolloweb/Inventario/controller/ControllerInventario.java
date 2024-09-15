package com.Desarrolloweb.Inventario.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.Desarrolloweb.Inventario.model.Producto;
import com.Desarrolloweb.Inventario.repository.ProductoRepository;
import com.Desarrolloweb.Inventario.repository.ProductoRepositoryIface;

@Controller
@SessionAttributes("producto")
public class ControllerInventario {
    private ProductoRepositoryIface productoRepository = new ProductoRepository();

    @GetMapping("/productos")
    public String productos(Model model){
        model.addAttribute("mensaje","PRODUCTO NUEVO");
        Producto producto = new Producto();
        List<String> listaOpciones = Arrays.asList("procesadores", "video", "telefonia","almacenamiento", "perifericos","portatiles", "sonido","comunicaciones","video juegos","accesorios");
        model.addAttribute("opciones", listaOpciones);
        model.addAttribute("producto", producto);
        return "vistas/producto_nuevo";
    }

    @PostMapping("/consulta")
    public String consulta(@ModelAttribute Producto producto, Model model){
        model.addAttribute("producto", producto);
        model.addAttribute("mensaje", "Consulta del producto: "+producto.getDescripcion());
        model.addAttribute("disponible", producto.getDisponible());
        model.addAttribute("ultimoIngreso", producto.getUltimoIngreso());
        System.out.println(producto.getId());
        productoRepository.guardar(producto);
        return "redirect:/mostrar";
    }

    @GetMapping("/mostrar")
    public String mostrar(Model model){
        List<Producto> productos = productoRepository.mostrar();
        model.addAttribute("titulo", "lista de productos guardados");
        model.addAttribute("productos", productos);
        return "vistas/mostrar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model){
        productoRepository.eliminar(id);
        return "redirect:/mostrar";

    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable Long id, Model model){
        Producto producto= productoRepository.obtener(id);
        System.out.println(producto.getId());
        model.addAttribute("producto", producto);
        model.addAttribute("mensaje", "nuevo producto");
        List<String> listaOpciones = Arrays.asList("procesadores", "video", "telefonia","almacenamiento", "perifericos","portatiles", "sonido","comunicaciones","video juegos","accesorios");
        model.addAttribute("opciones", listaOpciones);
        return "vistas/producto_nuevo";

    }

    
}
