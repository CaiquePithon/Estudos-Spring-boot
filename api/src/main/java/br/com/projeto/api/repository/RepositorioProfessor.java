package br.com.projeto.api.repository;
    
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.model.Professor;

@Repository
public interface RepositorioProfessor extends CrudRepository<Professor, Integer> {

    List<Professor> findAll();
    
    Professor findByMatricula(String matricula);

    Professor findByNome(String nome);

    Professor findById(String Id);

    List<Professor> findByEscolaID(int escolaID);

    List<Professor> findByOrderByNome(); //Desc no final faz o contrario

    List<Professor> findByNomeOrderByIdadeDesc(String nome);

    List<Professor> findByNomeContaining(String termo);

    List<Professor> findByNomeStartsWith(String termo); 

    List<Professor> findByNomeEndsWith(String termo);
}
