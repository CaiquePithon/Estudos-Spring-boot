package br.com.projeto.api.model;

import lombok.Data;

  @Data
public class Professor {
    
    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    // private Enum Status;
    private int escolaID;
    private int usuarioID;
    private int idade;

}
