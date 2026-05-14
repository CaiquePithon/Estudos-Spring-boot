package br.com.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.api.model.Mensager;
import br.com.projeto.api.model.Professor;
import br.com.projeto.api.repository.RepositorioProfessor;

@Service
public class ProfessorService {
    
    @Autowired
    private Mensager mensager;

    @Autowired
    private RepositorioProfessor repositorio;

    // Cadastra um professor
    public ResponseEntity<?> cadastrar(Professor obj) {

        if (obj.getNome().equals("")){
            mensager.setMensagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(mensager, HttpStatus.BAD_REQUEST);
        }else if(obj.getNome().equals("") || obj.getIdade() < 0 || obj.getEmail().equals("") || obj.getTelefone().equals("") || obj.getMatricula().equals("") || obj.getUsuarioID() == 0 || obj.getEscolaID() == 0){
            mensager.setMensagem("Preencha corretamente com todas as informações");
            return new ResponseEntity<>(mensager, HttpStatus.BAD_REQUEST);
        }else{
            repositorio.save(obj);
            mensager.setMensagem("Professor cadastrado com sucesso");
            return new ResponseEntity<>(mensager, HttpStatus.CREATED);
        }
    }    

    // Lista todos os professores
    public ResponseEntity<?> listar(){

        return new ResponseEntity<>(repositorio.findAll(), HttpStatus.OK);
    }

    //Método para selecionar pessoas através do codigo
    public ResponseEntity<?> buscarPorCodigo(int codigo) {

        if(repositorio.countById(codigo) == 0){
            mensager.setMensagem("Não foi encontrado nenhum usuario");
            return new ResponseEntity<>(mensager, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(repositorio.findById(codigo), HttpStatus.OK);
        }
    }

    //Método para editar dados
    public ResponseEntity<?> editar(Professor obj) {

        if(repositorio.countById(obj.getId()) == 0){
            mensager.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensager, HttpStatus.NOT_FOUND);
        }else if(obj.getNome().equals("") || obj.getIdade() < 0 || obj.getEmail().equals("") || obj.getTelefone().equals("") || obj.getMatricula().equals("") || obj.getUsuarioID() == 0 || obj.getEscolaID() == 0){
            mensager.setMensagem("Preencha corretamente com todas as informações");
            return new ResponseEntity<>(mensager, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(repositorio.save(obj), HttpStatus.OK);
        }
    }

    //Método para remover dados
    public ResponseEntity<?> remover(int codigo) {
        if(repositorio.countById(codigo) == 0){
            mensager.setMensagem("O codigo informado não existe");
            return new ResponseEntity<>(mensager, HttpStatus.NOT_FOUND);
        }else{
            repositorio.deleteById(codigo);
            mensager.setMensagem("Professor removido com sucesso");
            return new ResponseEntity<>(mensager, HttpStatus.OK);
        }
    }

}
