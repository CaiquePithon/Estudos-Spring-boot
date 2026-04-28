package br.com.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.projeto.api.model.Professor;
import br.com.projeto.api.repository.ProfessorRepository;

@RestController
public class Controller {
    
    @Autowired
    private ProfessorRepository acao;

    @PostMapping("/cadastrarprofessor")
    public Professor cadastrar(@RequestBody Professor p) {
        return acao.save(p);
    }

    @GetMapping("")
    public String mensagem() {
        return "Hello World!";
    }

    @GetMapping("/boas-vindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Seja bem-vindo(a) à minha API, " + nome + "!";
    }

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Seja bem-vindo(a) à minha API!";
    }

    @PostMapping("/professor")
    public Professor professor(@RequestBody Professor p) {
        return p;
    }
}
