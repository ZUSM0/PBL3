package model;

import java.util.Iterator;

public class ULogista extends Usuario{
    static private ULogista instance = null; 
    Estoque estoque;
    
    private ULogista(String login, String senha) { // Implemnetação do Singleton
        super(login, senha);
    }
    
    static ULogista getInstance(){
        if(ULogista.instance == null){
            ULogista.instance = new ULogista("logista", "123");
        }
        return ULogista.instance;
    }
    
    public Produto adicionarProdutoNoEstoque(String descricao, double preco, String tipo, int estoque){
        Produto produto = new Produto(preco, tipo, descricao, estoque);
        if(this.estoque == null){
            this.estoque = Estoque.getInstancia();
        }
        this.estoque.adicionarProdutoNoEstoque(produto);
        return produto;
    }
    
    public boolean removerProdutoNoEstoque(Produto produto){
        return this.estoque.removerProdutoNoEstoque(produto);
    }
    
    public Iterator<Produto> listarProdutoNoEstoque(){
        return this.estoque.listarProdutoNoEstoque();
    }
    
    public Iterator<Produto> listarProdutoNoEstoque(String categoria){
        return this.estoque.listarProdutoNoEstoque(categoria);
    }
    
    public Iterator<UCliente> listarClientesLoja(){
        return loja.listarClientes();
    }
}
