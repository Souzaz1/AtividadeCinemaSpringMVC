package com.senacead.cinema.controller;

import com.senacead.cinema.model.Analise;
import com.senacead.cinema.model.Filme;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/filmes")
public class FilmesController {

    private List<Filme> filmes = new ArrayList<>();
    private List<Analise> analises = new ArrayList<>();

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "formularioCadastroFilme";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFilme(Filme filme) {
        if (filmes.isEmpty()) {
            filme.setId(1L);
        } else {
            Long maxId = filmes.stream().map(Filme::getId).max(Long::compare).orElse(0L);
            filme.setId(maxId + 1);
        }
        filmes.add(filme);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/listar")
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmes);
        return "listaFilmes";
    }

    @GetMapping("/detalhes/{id}")
    public String detalhesFilme(@PathVariable Long id, Model model) {
        Filme filme = filmes.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
        if (filme == null) {
            return "redirect:/filmes/listar";
        }
        List<Analise> analisesFilme = new ArrayList<>();
        for (Analise analise : analises) {
            if (analise.getFilme().getId().equals(id)) {
                analisesFilme.add(analise);
            }
        }
        model.addAttribute("filme", filme);
        model.addAttribute("analises", analisesFilme);
        return "detalhesFilme";
    }

    @PostMapping("/detalhes/{id}/adicionar-analise")
    public String adicionarAnalise(@PathVariable Long id, @RequestParam String analiseTexto, @RequestParam int nota) {
        Filme filme = filmes.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
        if (filme == null) {
            return "redirect:/filmes/listar";
        }
        Long analiseId = analises.isEmpty() ? 1L : analises.stream().map(Analise::getId).max(Long::compare).orElse(0L) + 1;
        Analise novaAnalise = new Analise(analiseId, filme, analiseTexto, nota);
        analises.add(novaAnalise);
        return "redirect:/filmes/detalhes/" + id;
    }
}
