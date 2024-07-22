package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Loja {
    static private Loja instancia = new Loja();
    private Estoque estoque;
    private UCliente cliente;
    private ArrayList<UCliente> clientes = new ArrayList<UCliente>();
    private ULogista logista = ULogista.getInstance();
    private ArrayList<Venda> vendas = new ArrayList<Venda>();

    private Loja(){
        
    }
    
    static Loja getInstancia(){ // Implementação do Singleton
        return Loja.instancia;
    }
    
    // Métodos gerais!
    public boolean cadastrarCliente(UCliente cliente){
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            return true;
        }
        return false;
    }
    
    public UCliente fazerLogin(String login, String senha){
        Iterator iterator = this.clientes.iterator();
        while(iterator.hasNext()){
            UCliente usuario = (UCliente) iterator.next();
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                this.cliente = usuario;
                return usuario;
            }
        }
        return null;
    }
    
    public Iterator<UCliente> listarClientes(){
        return this.clientes.iterator();
    }
    
    public Iterator<Produto> listarProdutosNoEstoque(){
        return estoque.listarProdutoNoEstoque();
    }
    
    public Iterator<Produto> listarProdutosNoEstoque(String categoria){
        return estoque.listarProdutoNoEstoque(categoria);
    }
    
    public void realizarPagamento(Pedido pedido, PagamentoStrategy metodoPagamento){
        Venda venda = new Venda(pedido, pedido.valorTotalPedido(), metodoPagamento);
        vendas.add(venda);
    }
    
    
    // Getters e Setters!
    

}
