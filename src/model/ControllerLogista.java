package model;

import java.util.Iterator;

public class ControllerLogista {
    private ULogista logista = ULogista.getInstance();
    private Loja loja = Loja.getInstancia();
    private Estoque estoque = Estoque.getInstancia();
    private boolean LogistaLogado = false;
    
    public ControllerLogista(){}
    
    // Metodos gerais! 
    public boolean fazerLoginLogista(String login, String senha){
        if(logista.getLogin().equals(login) && logista.getSenha().equals(senha)){
            LogistaLogado = true;
            return true;
        }
        return false;
    }
    
    public Produto adicionarProdutoNoEstoque(String descricao, double preco, String tipo, int quantEstoque){
        return this.logista.adicionarProdutoNoEstoque(descricao, preco, tipo, quantEstoque);
    }
    
    public boolean removerProdutoNoEstoque(Produto produto){
        return this.logista.removerProdutoNoEstoque(produto);
    }
    
    public Iterator<Produto> listarProdutoNoEstoque(){
        return this.logista.listarProdutoNoEstoque();
    }
    
    public Iterator<Produto> listarProdutoNoEstoqueComCategoria(String categoria){
        return this.logista.listarProdutoNoEstoque(categoria);
    }
    
    public Iterator<UCliente> listarClientesLoja(){ 
        return this.logista.listarClientesLoja();
    }
}
