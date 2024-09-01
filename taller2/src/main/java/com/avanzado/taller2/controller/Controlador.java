package com.avanzado.taller2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.avanzado.taller2.model.Vendedor;
import com.avanzado.taller2.repository.VendedorRepository;
import com.avanzado.taller2.repository.VendedorRepositoryIface;

@Controller
@SessionAttributes("vendedor") //atributo de la clase Vendedor
public class Controlador {
    private VendedorRepositoryIface vendedorRepository = new VendedorRepository();
    @GetMapping("consulta")
    public String consultaVendedor(Model model){
        Vendedor vendedor = new Vendedor();
        List<String> vendedoresL = Arrays.asList("Pedro Gonzalez Sanzana", "Flor Esilda Bustos Riffo", "Mario Escobar Navarro","Isabel Zunilda Encina Bello", 
        "Luis Felipe Erazo Castro","Nilda Meza Maldonado", "Rene Alberto Camilo Mosquera","Uberlinda Mella Arellano","Rigoberto Caceres Monsalve","Susana Angela Mora Soutullo",
        "Ana Mercedes Perez Perez","Roberto Rivas Avello","Sergio Ibañez Torres","Mauricio Javier Bravo Obando");
        model.addAttribute("vendedoresL", vendedoresL);
        model.addAttribute("titulo", "Ventas del vendedor");
        model.addAttribute("vendedor", vendedor);
        return "vistas/consulta";
    }
    @PostMapping("/procesarconsulta")
    public String mostrarVendedor(@ModelAttribute Vendedor vendedor){
        return "redirect:/respuesta";
    }
    @GetMapping("/respuesta")
    public String listaVendedores(Model model, Vendedor vendedor){
        List<String> vendedoresL = Arrays.asList("Pedro Gonzalez Sanzana", "Flor Esilda Bustos Riffo", "Mario Escobar Navarro","Isabel Zunilda Encina Bello", 
        "Luis Felipe Erazo Castro","Nilda Meza Maldonado", "Rene Alberto Camilo Mosquera","Uberlinda Mella Arellano","Rigoberto Caceres Monsalve","Susana Angela Mora Soutullo",
        "Ana Mercedes Perez Perez","Roberto Rivas Avello","Sergio Ibañez Torres","Mauricio Javier Bravo Obando");
        model.addAttribute("vendedoresL", vendedoresL);
        List<Vendedor> vendedores = vendedorRepository.mostrar();
        int total=0;
        for (Vendedor ven : vendedores){
            total=ven.getVendedor().equals(vendedor.getVendedor()) ? total+=ven.getValor():total;
        }
        model.addAttribute("total", total);
        model.addAttribute("titulo", "Ventas del vendedor: "+vendedor.getVendedor());
        model.addAttribute("vendedores",vendedores);
        return "vistas/consulta";
    }

    
}
