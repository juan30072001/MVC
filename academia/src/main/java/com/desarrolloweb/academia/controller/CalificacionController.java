package com.desarrolloweb.academia.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.desarrolloweb.academia.model.Calificacion;
import com.desarrolloweb.academia.repository.CalificacionRepository;
import com.desarrolloweb.academia.repository.CalificacionRepositoryIface;

@Controller
//monta los datos que cargamos desde el controller a la vista 
//si el usuario no los cambia vuelven al controlador
@SessionAttributes("calificacion") //se carga el dato como un atributo de sesion cuando se envian los datos del controller a la vista
public class CalificacionController {

    private CalificacionRepositoryIface calificacionRepository = new CalificacionRepository(); // no se instancia de la interfaz

    @GetMapping("/formulario")
    public String formulario(Model model) {
        Calificacion calificacion = new Calificacion();
        calificacion.setAsignatura("ingles 2");
        calificacion.setToken("UT-897"); // si en la vista no esta presente el campo cuando los datos vuelvan de la vista al controlador no regresan al controlador
        model.addAttribute("calificacion", calificacion);
        model.addAttribute("titulo", "Registro de nueva calificación");
        return "vistas/formulario";
    }
    
    @PostMapping("/procesarform")
    //el sessionstatus desmonta la sesion de usuario
    public String procesarForm(@ModelAttribute Calificacion calificacion, Model model, SessionStatus status) { //modelo para enviar datos a la vista desde el controller
        //System.out.println(calificacion);
        // model.addAttribute("titulo", "Consulta de calificación procesada");
        // model.addAttribute("calificacion", calificacion);
        calificacionRepository.guardar(calificacion);// se usa el metodo "guardar" de la interfaz 
        status.setComplete(); //desmonta la session 
        return "redirect:/listado"; // redireccion:desde un metodo del controlador puedo llamar a otro metodo del controlador
    }
    @GetMapping("/listado")
    public String listadoCalificaciones(Model model){
        List<Calificacion> calificaciones = calificacionRepository.obtenerTodos();
        model.addAttribute("titulo", "listado de calificaciones");
        model.addAttribute("calificaciones", calificaciones);
        
        return "vistas/listado";

    }
    
    @ModelAttribute("departamentos") //si esta mapeado con @ModelAttribute lo que devuelva el metodo va a ser accedido por cualquier vista
    public List<String> departamentos() {
        return Arrays.asList("Informática", "Idiomas", "Algoritmos", "Programación", 
            "Matemáticas", "Estadística", "Administración", "Humanidades", "Cultura");
    }


}