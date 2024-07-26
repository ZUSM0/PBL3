package model;

public class Produto{
    private double preco;
    private String tipo;
    private String descricao;
    private int quantidadeEstoque;
    
    public Produto(double preco, String tipo, String descricao, int estoque){
        this.preco = preco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.quantidadeEstoque = estoque;
    }
    
    // GETTERS E SETTERS!
    public double getPreco(){
        return this.preco;
    }
    
    public String getTipo(){
        return this.tipo;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantEstoque(){
        return this.quantidadeEstoque;
    }
    
    public void setEstoque(int comprados){ // Reduz a quantidade do quantidadeEstoque.
        this.quantidadeEstoque -= comprados;
    }  
}
