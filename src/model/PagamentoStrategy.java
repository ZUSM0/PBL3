package model;

public interface PagamentoStrategy {
    int PIX = 0;
    int PICPAY = 1;
    int CARTAO = 2;
    
    public boolean pagar(double valor, Object... dados);

}
