package br.com.projeto.api.repository;
    
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.projeto.api.model.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    List<Professor> findAll();
    
}
