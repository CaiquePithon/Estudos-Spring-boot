package br.com.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.exception.ProfessorNotFoundException;
import br.com.projeto.api.model.Professor;
import br.com.projeto.api.repository.RepositorioProfessor;

@RestController
public class Controller {
    
    @Autowired
    private RepositorioProfessor acao;

    //Cadastra um professor (POST)
    @PostMapping("/professor/cadastrar")
    public Professor cadastrar(@RequestBody Professor p) {
        return acao.save(p);
    }

    //Mostra a lista de professores cadastrados (GET)
    @GetMapping("/professor/listar/todos")
    public List<Professor> listar() {
        return acao.findAll();
    }

    //Mostra o professor com a matricula procurada (GET)
    @GetMapping("/professor/listar/{matricula}")
    public Professor listar(@PathVariable String matricula) {
        return acao.findByMatricula(matricula);
    }

    // Contador de professores cadastrados (GET)
    @GetMapping("/professor/contador")
    public long contador() {
        return acao.count();
    }

    // Mostra a lista de professores ordenada por Nome (GET)
    @GetMapping("/professor/ordenar/nome")
    public List<Professor> ordenarNome(){
        return acao.findByOrderByNome();
    }

    // Mostra a lista de professores ordenada por Nome (GET)
    @GetMapping("/professor/ordenar/nome-idade/{nome}")
    public List<Professor> ordenarNomeIdade(@PathVariable String nome){
        return acao.findByNomeOrderByIdadeDesc(nome);
    }

    @GetMapping("/professor/buscar/nome/{termo}")
    public List<Professor> buscarTermo(@PathVariable String termo) {
        return acao.findByNomeContaining(termo);
    }
    
    @GetMapping("/professor/buscar/inicia-com/{termo}")
    public List<Professor> iniciaCom(@PathVariable String termo) {
        return acao.findByNomeStartsWith(termo);
    }

    @GetMapping("/professor/buscar/termina-com/{termo}")
    public List<Professor> terminaCom(@PathVariable String termo) {
        return acao.findByNomeEndsWith(termo);
    }

    //Editar professor (UPDATE)
    @PutMapping("/professor/editar")
    public Professor editar(@RequestBody Professor p){
        return acao.save(p);
    }
    
    //Remover professor (DELETE)
    @DeleteMapping("/professor/remover/{id}")
    public ResponseEntity<String> remover(@PathVariable int id) {
    Professor p = acao.findById(id)
            .orElseThrow(() -> new ProfessorNotFoundException(id));      
    acao.delete(p);
    return ResponseEntity.ok("Professor removido com sucesso.");
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
