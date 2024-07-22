package model.Composite;

import model.Produto;

import java.util.Iterator;


public interface EstoqueComposite { // Parte da implementação do Padrão composite
    public EstoqueComposite adicionarProdutoNoEstoque(Produto produto);
    
    public boolean removerProdutoNoEstoque(Produto produto);
    
    public Iterator<Produto> listarProdutoNoEstoque();
    
    public String getCategoria();
}
