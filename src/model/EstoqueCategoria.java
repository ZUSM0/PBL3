package model;

import model.Composite.EstoqueComposite;

import java.util.ArrayList;
import java.util.Iterator;


public class EstoqueCategoria implements EstoqueComposite {
    private String categoria;
    private ArrayList<Produto> produtosCategoria = new ArrayList<>();
    
    public EstoqueCategoria(String categoria){
        this.categoria = categoria;
    }
    
    @Override
    public EstoqueComposite adicionarProdutoNoEstoque(Produto produto){
        produtosCategoria.add(produto);
        return this;
    }
    
    @Override
    public boolean removerProdutoNoEstoque(Produto produto){
        return produtosCategoria.remove(produto);
    }
    
    @Override
    public Iterator<Produto> listarProdutoNoEstoque() {
        return produtosCategoria.iterator();
    }
    
    // Getters e Setters!
    @Override
    public String getCategoria(){
        return this.categoria;
    }
}
