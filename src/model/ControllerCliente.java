package model;

import java.util.Iterator;

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
    
    public boolean adicionarProdutoNoCarrinho(Produto produto, int quantidade){
        return cliente.adicionarProdutoNoCarrinho(produto, quantidade);
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
        this.pedidoAtual = this.cliente.fecharPedido();
        this.valorCarrinho = pedidoAtual.valorTotalPedido();
        return this.pedidoAtual;
    }
    
    public PagamentoStrategy escolherPagamento(int pagamentoStrategy){
        this.pagamento = cliente.escolherPagamento(pagamentoStrategy);
        return this.pagamento;
    }
    
    private void finalizarPedido(){
        loja.registrarVenda(pedidoAtual, this.pagamento); 
        this.cliente.limparCarrinho();
    }
    
    public boolean realizarPagamento(Object... dados){
        if(this.cliente.realizarPagamento(this.valorCarrinho, dados)){ // Se o pagamento for aprovado, fazemos a redução do estoque.
            Iterator iterator = pedidoAtual.listarProdutosCarrinho();
            while(iterator.hasNext()){
                Itens item = (Itens)iterator.next();
                loja.reduzProdutoNoEstoque(item.getProduto(), item.getQuantidade());
            }          
            this.finalizarPedido();// Após o pagamento aprovado e os produtos terem sido reduzidos do estoque, a venda é registrada pela loja e o carrinho é limpo.
            return true;
        }
        return false;
    }
    
}
