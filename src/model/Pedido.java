package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Pedido {
    private ArrayList<Itens> itens = new ArrayList<>();
    
    public Pedido(ArrayList<Itens> carrinho){
        this.itens = carrinho;
    }
    
    public Iterator<Itens> listarProdutosCarrinho(){ 
        return itens.iterator();
        
    }
    
    public double valorTotalPedido(){
        double valor = 0;
        Iterator<Itens> iterator = itens.iterator();
        while(iterator.hasNext()){
            Itens item = iterator.next();
            valor += item.getPreco() * item.getQuantidade();
        }
        return valor;
    }    
}
