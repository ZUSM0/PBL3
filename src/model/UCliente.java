package model;

import java.util.ArrayList;
import java.util.Iterator;

public class UCliente extends Usuario {
    private String nome;
    private String endereco;
    private ArrayList<Itens> carrinho = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public UCliente(String nome, String login, String senha, String endereco) {
        super(login, senha);
        this.nome = nome;
        this.endereco = endereco;   
    }
    
    // Métodos principais!
    public void adicionarProdutoNoCarrinho(Produto produto, int quantidade){
        Itens item = new Itens(produto, quantidade, produto.getPreco());
        carrinho.add(item);
    }
    
    public boolean removerProdutoNoCarrinho(Produto produto){ 
        Iterator<Itens> iterator = carrinho.iterator();
        while(iterator.hasNext()){ // Percorre o carrinho todo
            Itens item = iterator.next();
            if(item.getProduto() == produto){ // Se o produto que eu quero remover for igual ao acabei de percorrer
                return carrinho.remove(item);// Eu removo ele 
            }
        }
        return false;
    }
    
    public Iterator<Itens> listarProdutosNoCarrinho(){
        return this.carrinho.iterator();
    }
    
    public double fecharPedido(){
        Pedido pedido = new Pedido(this.carrinho);
        pedidos.add(pedido);
        double valor = this.calcularCarrinho();
        this.carrinho.clear();

        return valor; // retorna valor total do carrinho e limpa o carrinho
    }
    
    //Cliente precisa poder realizar pagamento. Só transferir o codigo do controller para cá
    
    // Métodos auxiliares!
    public double calcularCarrinho(){
        Iterator iterator = this.listarProdutosNoCarrinho();
        double valor = 0;
        while(iterator.hasNext()){
            Itens item = (Itens) iterator.next();
            valor += item.getPreco()*item.getQuantidade();
        }
        return valor;
    }
    
    //GETTERS E SETTERS!
    public Iterator<Itens> getCarrinho(){
        return this.carrinho.iterator();
    }
    

}
