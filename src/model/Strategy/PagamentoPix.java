package model.Strategy;

import model.PagamentoStrategy;

public class PagamentoPix implements PagamentoStrategy {
    private double valor;
    private String chavePix;
    public PagamentoPix() {
    }
    
    @Override
    public boolean pagar(double valor, Object... dados) {       
        if(dados.length == 1){
            this.valor = valor;
            this.chavePix = (String) dados[0];
            return true;
        }
        return false;
    }

    
}
