package com.senacead.cinema.controller;

import com.senacead.cinema.model.Filme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class CinemaController {
    
    @GetMapping("/")
    public String inicio(){ 
        return "index";
    }
    
    @GetMapping("/inicio")
    public String inicio1(){
        return "index";
    }
    
    @Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "formularioCadastroFilme";
    }
}
    
}
