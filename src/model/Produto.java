package model;

public class Produto{
    private double preco;
    private String tipo;
    private String descricao;
    private int estoque;
    
    public Produto(double preco, String tipo, String descricao, int estoque){
        this.preco = preco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.estoque = estoque;
    }
    
    // GETTERS E SETTERS!
    public double getPreco(){
        return this.preco;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setEstoque(int comprados){ // Reduz a quantidade do estoque.
        this.estoque -= comprados;
    }  
}
