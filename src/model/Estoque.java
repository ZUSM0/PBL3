package model;

import model.Composite.EstoqueComposite;

import java.util.ArrayList;
import java.util.Iterator;

public class Estoque implements EstoqueComposite{
    private String categoria = "Geral";
    private static Estoque instancia = new Estoque();
    private ULogista logista = ULogista.getInstance();
    private ArrayList<EstoqueComposite> produtos = new ArrayList<>();
    
    private Estoque(){}
    
    public static Estoque getInstancia(){ // Padrão Singleton
        return Estoque.instancia;
    }
       
    @Override
    public EstoqueComposite adicionarProdutoNoEstoque(Produto produto){
        for(EstoqueComposite componente: produtos){
            if(componente.getCategoria().equals(produto.getTipo())){
                produtos.add(componente);
                return componente.adicionarProdutoNoEstoque(produto);       
            }
        }
        EstoqueComposite componente = new EstoqueCategoria(produto.getTipo());
        produtos.add(componente);
        return componente.adicionarProdutoNoEstoque(produto);
        
    }
    
    @Override
    public boolean removerProdutoNoEstoque(Produto produto){
        for(EstoqueComposite componente: produtos){
            if(componente.getCategoria().equals(produto.getTipo())){
               return componente.removerProdutoNoEstoque(produto);                      
            }
        }
        return false;
    }
    
    @Override
    public Iterator<Produto> listarProdutoNoEstoque(){
        ArrayList<Produto> produtosGerais = new ArrayList<>();
        for(EstoqueComposite componente: produtos){
            Iterator iterator = componente.listarProdutoNoEstoque();
            while(iterator.hasNext()){
                produtosGerais.add((Produto) iterator.next());
            }
        }
        return produtosGerais.iterator();
    }
    
    public Iterator<Produto> listarProdutoNoEstoque(String categoria){
        for(EstoqueComposite componente: produtos){
            if(componente.getCategoria().equals(categoria)){
               return componente.listarProdutoNoEstoque();                      
            }
        }
        return null;
    }
    
    // Getters e Setters!
    @Override
    public String getCategoria(){
        return this.categoria;
    }
        
}
