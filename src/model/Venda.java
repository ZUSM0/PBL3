package model;

public class Venda {
    private Pedido pedido;
    private double valorTotalPedido;
    private PagamentoStrategy metodoPagamento;
    
    public Venda(Pedido pedido, double valorTotalPedido, PagamentoStrategy metodoPagamento){
        this.pedido = pedido;
        this.valorTotalPedido = valorTotalPedido;
        this.metodoPagamento = metodoPagamento;
    }
    
    // Getters e Setters!
    public Pedido getPedido(){
        return this.pedido;
    }
    
    public double getValorTotalpedido(){
        return this.valorTotalPedido;
    }
    
    public PagamentoStrategy getPagamento(){
        return this.metodoPagamento;
    }
        
}
