package model;

import java.util.Iterator;
import model.Strategy.PagamentoCartao;
import model.Strategy.PagamentoPicPay;
import model.Strategy.PagamentoPix;

import java.util.Map;


public class ControllerCliente {
    private UCliente cliente;
    private Loja loja = Loja.getInstancia();
    private PagamentoStrategy pagamento;
    private Pedido pedidoAtual;
    private double valorCarrinho;    

    
    public ControllerCliente(){}
    
    //Métodos gerais!
    public UCliente cadastrarUsuario(String nome, String login, String senha, String endereco){
        UCliente cliente = new UCliente(nome, login, senha, endereco);
        loja.cadastrarCliente(cliente);
        return cliente;
    }
    
    public UCliente fazerLogin(String login, String senha){
        this.cliente = loja.fazerLogin(login, senha);
        return this.cliente;
    }
    
    public void adicionarProdutoNoCarrinho(Produto produto, int quantidade){
        cliente.adicionarProdutoNoCarrinho(produto, quantidade);
    }
    
    public boolean removerProdutoNoCarrinho(Produto produto){
        return cliente.removerProdutoNoCarrinho(produto);
    }
    
    public Iterator<Itens> listarProdutosNoCarrinho(){
        return this.cliente.listarProdutosNoCarrinho();
    }
    
    public double valorCarrinho(){
        return cliente.calcularCarrinho();
    }
      
    public Pedido fecharPedido(){
        this.pedidoAtual = fecharPedido();
        this.valorCarrinho = pedidoAtual.valorTotalPedido();
        return this.pedidoAtual;
    }
    
    public PagamentoStrategy escolherPagamento(int pagamentoStrategy){
        this.pagamento = cliente.escolherPagamento(pagamentoStrategy);
        return this.pagamento;
    }
    
    public void finalizarPedido(){
        // Precisa??? Talvez sim para limpar o carrinho. Carrinho só é limpo quando a venda acabar
    }
    
    public boolean realizarPagamento(Object... dados){
        // Lembrar de fazer redução no estoque, somente se o pagamento for comprovado
        // A classe Venda é chamada aqui também
        return pagamento.pagar(this.valorCarrinho, dados);
    }
    
}
