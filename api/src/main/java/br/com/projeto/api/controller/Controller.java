package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.model.Professor;
import br.com.projeto.api.repository.Repositorio;

@RestController
public class Controller {
    
    @Autowired
    private Repositorio acao;

    @PostMapping("/cadastrarprofessor")
    public Professor cadastrar(@RequestBody Professor p) {
        return acao.save(p);
    }

    @GetMapping("/listarprofessores")
    public List<Professor> listar() {
        return acao.findAll();
    }

    @GetMapping("/professor/{matricula}")
    public Professor listar(@PathVariable String matricula) {
        return acao.findByMatricula(matricula);
    }


    // @PostMapping("/professor")
    // public Professor professor(@RequestBody Professor p) {
    //     return p;
    // }

    // @GetMapping("")
    // public String mensagem() {
    //     return "Hello World!";
    // }

    @GetMapping("/boas-vindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem-vindo(a) à minha API, " + nome + "!";
    }

    @GetMapping("")
    public String boasVindas() {
        return "Seja bem-vindo(a) à minha API!";
    }

}
