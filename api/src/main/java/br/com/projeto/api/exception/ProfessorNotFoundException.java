package br.com.projeto.api.exception;

public class ProfessorNotFoundException extends RuntimeException {
    public ProfessorNotFoundException(int id) {
        super("Professor com id " + id + " não encontrado.");
    }
}
