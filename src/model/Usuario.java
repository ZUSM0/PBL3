package model;

public abstract class Usuario {
    protected String login;
    protected String senha;
    protected Loja loja = Loja.getInstancia();
    
    public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    // Getters e Setters!
    public String getLogin(){
        return this.login;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public Loja getLoja(){
        return this.loja;
    }
}
