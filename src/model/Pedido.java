package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private ArrayList<Itens> carrinho = new ArrayList<>();
    
    public Pedido(ArrayList<Itens> carrinho){
        this.carrinho = carrinho;
    }
    
    public Iterator<Itens> listarProdutosCarrinho(){ 
        return carrinho.iterator();
        
    }
    
    public double valorTotalCarrinho(){
        double valor = 0;
        Iterator<Itens> iterator = carrinho.iterator();
        while(iterator.hasNext()){
            Itens item = iterator.next();
            valor += item.getPreco() * item.getQuantidade();
        }
        return valor;
    }    
}
