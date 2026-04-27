package br.com.projeto.api.model;

public class Professor {


    //Atributos
    private String matricula;
    private String nome;
    private String email;
    private String telefone;
    // private Enum Status;
    private int escolaID;
    private int usuarioID;
    private int idade;

    //Gets e Sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getEscolaID() {
        return escolaID;
    }
    public void setEscolaID(int escolaID) {
        this.escolaID = escolaID;
    }
    public int getUsuarioID() {
        return usuarioID;
    }
    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }
    

    
    
}
