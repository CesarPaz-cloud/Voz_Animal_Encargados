package com.cibertec.demo.controller;

import com.cibertec.demo.model.Encargados;
import com.cibertec.demo.service.EncargadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class EncargadosController {

    @Autowired
    private EncargadoService encargadoService;

    @GetMapping("/encargado")
    public String PaginaInicio(Model model){
        model.addAttribute("listaEncargados",encargadoService.listarEncargados());
        return "encargado/encargado";
    }

    @GetMapping("/nuevoEncargado")
    public String agregarEncargado(Model model){
        Encargados encargados = new Encargados();
        model.addAttribute("Encargados", encargados);
        return "encargado/nuevoEncargado";
    }

    @PostMapping("/guardarEncargado")
    public String guardarEncargdo(@ModelAttribute("encargado") Encargados encargados) {
        encargadoService.guardarEncargos(encargados);
        return "redirect:/encargados";
    }
    @GetMapping("/actualizarEncargados/(id)")
    public String actualizarEncargado(@PathVariable(value = "id") long id, Model model){
        Encargados encargados = encargadoService.obtenerEncargados(id);
        model.addAttribute("encargados", encargados);
        return  "encargados/actualizarEncargados";
    }
    @GetMapping("/eliminarEncargados/(id)")
    public String eliminarEncargado(@PathVariable(value = "id") long id){
        encargadoService.eliminarEncargados(id);
        return "redirect:/encargados";
    }
}
