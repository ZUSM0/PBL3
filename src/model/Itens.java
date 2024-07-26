package model;

public class Itens {
    private Produto produto;
    private int quantidade;
    private double preco;
    
    public Itens(Produto produto, int quantidade, double preco){
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    
    //GETTERS E SETTERS!
    public Produto getProduto(){
        return this.produto;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }   
}
