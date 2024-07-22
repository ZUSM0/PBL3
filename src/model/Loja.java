package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Loja {
    static private Loja instancia = null;
    private Estoque estoque;
    private UCliente cliente;
    private ArrayList<UCliente> clientes = new ArrayList<UCliente>();
    private ULogista logista = ULogista.getInstance();
    private Venda venda;

    private Loja(){
        
    }
    
    static Loja getInstancia(){ // Implementação do Singleton
        if(Loja.instancia == null){
            instancia = new Loja();        
        }
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
    
    
    
    // Getters e Setters!
    

}
