package model;

import model.Composite.EstoqueComposite;

import java.util.ArrayList;
import java.util.Iterator;

public class Estoque implements EstoqueComposite{
    private String categoria = "Geral";
    private static Estoque instancia = new Estoque();
    private ULogista logista = ULogista.getInstance();
    private ArrayList<EstoqueComposite> produtosCategoria = new ArrayList<>();
    
    private Estoque(){}
    
    public static Estoque getInstancia(){ // Padrão Singleton
        return Estoque.instancia;
    }
       
    @Override
    public EstoqueComposite adicionarProdutoNoEstoque(Produto produto){
        
        Iterator<EstoqueComposite> iterator = produtosCategoria.iterator();
        while (iterator.hasNext()) { // Percorre todas as categorias do estoque...
            EstoqueComposite componente = iterator.next();
            if (componente.getCategoria().equals(produto.getTipo())) { // E procura a categoria que guarda o mesmo tipo do produto que foi passado.
                return componente.adicionarProdutoNoEstoque(produto);  
            }
        }
        
        EstoqueComposite componente = new EstoqueCategoria(produto.getTipo()); // Se não achar, criamos uma nova categoria para guardar o produto.
        produtosCategoria.add(componente);
        return componente.adicionarProdutoNoEstoque(produto);
        
    }
    
    @Override
    public boolean removerProdutoNoEstoque(Produto produto){
        for(EstoqueComposite componente: produtosCategoria){
            if(componente.getCategoria().equals(produto.getTipo())){
               return componente.removerProdutoNoEstoque(produto);                      
            }
        }
        return false;
    }
    
    @Override
    public void reduzProdutoNoEstoque(Produto produto, int quant){
        for(EstoqueComposite componente: produtosCategoria){
            if(componente.getCategoria().equals(produto.getTipo())){
               componente.reduzProdutoNoEstoque(produto, quant);
            }
        }
    }
    
    @Override
    public Iterator<Produto> listarProdutoNoEstoque(){ // Retorna todos os produtos do estoque independente da categoria.
        ArrayList<Produto> produtosGerais = new ArrayList<>();
        for(EstoqueComposite componente: produtosCategoria){
            Iterator<Produto> iterator = componente.listarProdutoNoEstoque();
            while(iterator.hasNext()){
                produtosGerais.add((Produto) iterator.next());
            }
        }
        return produtosGerais.iterator();
    }
    
    public Iterator<Produto> listarProdutoNoEstoque(String categoria){ // Exemplo de sobrecarga de método, retorna todos os produtos de uma categoria especifica.
        for(EstoqueComposite componente: produtosCategoria){
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
