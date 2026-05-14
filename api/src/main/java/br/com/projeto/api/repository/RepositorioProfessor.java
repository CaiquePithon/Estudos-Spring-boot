package br.com.projeto.api.repository;
    
import java.util.List;

import org.springframework.data.jpa.repository.Query;
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

    @Query(value ="SELECT SUM(idade) FROM professores", nativeQuery = true)
    int somaIdades();

    @Query(value = "SELECT * FROM professores WHERE idade >= :idade", nativeQuery = true)
    List<Professor> idadeMaiorIgual(int idade);

    int countById(int id);

    Professor deleteById(int id);
}
