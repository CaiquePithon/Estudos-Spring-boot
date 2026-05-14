package br.com.projeto.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.model.Professor;
import br.com.projeto.api.repository.RepositorioProfessor;
import br.com.projeto.api.service.ProfessorService;

@RestController
public class Controller {
    
    @Autowired
    private ProfessorService service;

    @Autowired
    private RepositorioProfessor acao;

    //Cadastra um professor (POST)
    @PostMapping("/professores/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Professor p) {
        return service.cadastrar(p);
    }

    //Mostra a lista de professores cadastrados (GET)
    @GetMapping("/professores")
    public ResponseEntity<?> listar() {
        return service.listar();
    }
    
    //Mostra o professor com a matricula procurada (GET)
    @GetMapping("/professores/listar/{matricula}")
    public Professor listar(@PathVariable String matricula) {
        return acao.findByMatricula(matricula);
    }

    // Contador de professores cadastrados (GET)
    @GetMapping("/professores/contador")
    public long contador() {
        return acao.count();
    }

    @GetMapping("/professores/{codigo}")
    public ResponseEntity<?> bucarPorCodigo(@PathVariable int codigo) {
        return service.buscarPorCodigo(codigo);
    }
    

    // Mostra a lista de professores ordenada por Nome (GET)
    @GetMapping("/professores/ordenar/nome")
    public List<Professor> ordenarNome(){
        return acao.findByOrderByNome();
    }

    // Mostra a lista de professores ordenada por Nome e qual tem a idade maior (GET)
    @GetMapping("/professores/ordenar/nomeIdade/{nome}")
    public List<Professor> ordenarNomeIdade(@PathVariable String nome){
        return acao.findByNomeOrderByIdadeDesc(nome);
    }

    // Mostra a lista de professores buscando por um termo (GET)
    @GetMapping("/professores/buscar/nome/{termo}")
    public List<Professor> buscarTermo(@PathVariable String termo) {
        return acao.findByNomeContaining(termo);
    }
    
    // Mostra a lista de professores buscando por um termo no Inicio(GET)
    @GetMapping("/professores/buscar/iniciaCom/{termo}")
    public List<Professor> iniciaCom(@PathVariable String termo) {
        return acao.findByNomeStartsWith(termo);
    }

    // Mostra a lista de professores buscando por um termo no Final(GET)
    @GetMapping("/professores/buscar/terminaCom/{termo}")
    public List<Professor> terminaCom(@PathVariable String termo) {
        return acao.findByNomeEndsWith(termo);
    }

    // Soma das idades dos professores (GET)
    @GetMapping("/professores/somaIdades")
    public int somaIdades() {
        return acao.somaIdades();
    }

    // Mostra a lista de professores com idade maior ou igual a idade procurada (GET)
    @GetMapping("/professores/idadeMaiorIgual/{idade}")
    public List<Professor> idadeMaiorIgual(@PathVariable int idade) {
        return acao.idadeMaiorIgual(idade);
    }

    // Status da API (GET)
    @GetMapping("/status")
    public ResponseEntity<?> status() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //Editar professor (UPDATE)
    @PutMapping("/professores/editar")
    public ResponseEntity<?> editar(@RequestBody Professor p){
        return service.editar(p);
    }
    
    //Remover professor (DELETE)
    @DeleteMapping("/professores/remover/{id}")
    public ResponseEntity<?> remover(@PathVariable int id) {
        return service.remover(id);
    }   

    

    // @PostMapping("/professor")
    // public Professor professor(@RequestBody Professor p) {
    //     return p;
    // }

    // @GetMapping("")
    // public String mensagem() {
    //     return "Hello World!";
    // }

    // @GetMapping("/boas-vindas/{nome}")
    // public String boasVindas(@PathVariable String nome) {
    //     return "Seja bem-vindo(a) à minha API, " + nome + "!";
    // }

    // @GetMapping("")
    // public String boasVindas() {
    //     return "Seja bem-vindo(a) à minha API!";
    // }

}
