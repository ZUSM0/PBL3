package model;

import model.Strategy.PagamentoCartao;
import model.Strategy.PagamentoPicPay;
import model.Strategy.PagamentoPix;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class UCliente extends Usuario {
    private String nome;
    private String endereco;
    private ArrayList<Itens> carrinho = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private PagamentoStrategy pagamento;
    private final Map<Integer, PagamentoStrategy> metodosPagamentoConcreto = Map.of( // Parte da impletementação do Strategy
            PagamentoStrategy.PIX, new PagamentoPix(),
            PagamentoStrategy.PICPAY, new PagamentoPicPay(),
            PagamentoStrategy.CARTAO, new PagamentoCartao()           
    );

    public UCliente(String nome, String login, String senha, String endereco) {
        super(login, senha);
        this.nome = nome;
        this.endereco = endereco;   
    }
    
    // Métodos principais!
    public boolean adicionarProdutoNoCarrinho(Produto produto, int quantidade){
        if(produto.getQuantEstoque() >= quantidade){
            Itens item = new Itens(produto, quantidade, produto.getPreco());
            carrinho.add(item);
            return true;
        }
        return false;
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
    
    public Pedido fecharPedido(){
        Pedido pedido = new Pedido(this.carrinho);
        pedidos.add(pedido);
        return pedido;
    }
    
    public PagamentoStrategy escolherPagamento(int pagamentoStrategy){
        this.pagamento = this.metodosPagamentoConcreto.get(pagamentoStrategy);
        return this.pagamento;
    }
    
    public boolean realizarPagamento(double valorCarrinho, Object... dados){
        return this.pagamento.pagar(valorCarrinho, dados);
    }
    
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
    
    public void limparCarrinho(){
        this.carrinho.clear();
    }
    
    //GETTERS E SETTERS!
    public Iterator<Itens> getCarrinho(){
        return this.carrinho.iterator();
    }
    

}
