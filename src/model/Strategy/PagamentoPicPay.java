package model.Strategy;

import model.PagamentoStrategy;

public class PagamentoPicPay implements PagamentoStrategy {
    private String email;
    private String senha;
    private double valor;
    
    public PagamentoPicPay(){}
    
    @Override
    public boolean pagar(double valor, Object... dados) {
        if(dados.length == 2){
            this.valor = valor;
            this.email = (String) dados[0];
            this.senha = (String) dados[1];
            return true;
        }
        return false;
    }

}
