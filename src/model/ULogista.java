package model;

import java.util.Iterator;

public class ULogista extends Usuario{
    static private ULogista instance = null; 
    Estoque estoque = Estoque.getInstancia();
    
    private ULogista(String login, String senha) { // Singleton?
        super(login, senha);
    }
    
    static ULogista getInstance(){
        if(ULogista.instance == null){
            ULogista.instance = new ULogista("Logista", "123");
        }
        return ULogista.instance;
    }
    
    public void adicionarProdutoNoEstoque(String descricao, int preco, String tipo, int estoque){
        Produto produto = new Produto(preco, tipo, descricao, estoque);
        this.estoque.adicionarProdutoNoEstoque(produto);
    }
    
    public boolean removerProdutoNoEstoque(Produto produto){
        return this.estoque.removerProdutoNoEstoque(produto);
    }
    
    public Iterator<UCliente> listarClientesLoja(){
        return loja.listarClientes();
    }
}
