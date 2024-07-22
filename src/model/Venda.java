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
    
    public void processarVenda(){
        
    }
        
}
