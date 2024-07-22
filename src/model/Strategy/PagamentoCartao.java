package model.Strategy;

import model.PagamentoStrategy;

public class PagamentoCartao implements PagamentoStrategy  {
    private String nome;
    private String numeroCartao;
    private String cvv;
    private String anoVencimento;
    private double valor;
    
    public PagamentoCartao(){}
    
    @Override
    public boolean pagar(double valor, Object... dados) {
        if(dados.length == 4){
            this.nome = (String) dados[0];
            this.numeroCartao = (String) dados[1];
            this.cvv = (String) dados[2];
            this.numeroCartao = (String) dados[3];
            this.valor = valor;
            return true;
        }
        return false;
    }

}
