package model.Composite;

import model.Produto;

import java.util.Iterator;


public interface EstoqueComposite { // Parte da implementação do Padrão composite
    public EstoqueComposite adicionarProdutoNoEstoque(Produto produto);
    
    public boolean removerProdutoNoEstoque(Produto produto);
    
    public void reduzProdutoNoEstoque(Produto produto, int comprados);
    
    public Iterator<Produto> listarProdutoNoEstoque();
    
    public String getCategoria();
}
