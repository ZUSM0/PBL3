package model;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerClienteTest {
    
    private UCliente u1, u2;
    private ControllerCliente ccl = new ControllerCliente();
    private ControllerLogista clog = new ControllerLogista();
    private Produto p1, p2, p3;
    public ControllerClienteTest() {
    }

    @Before
    public void setUp() {
        u1 = ccl.cadastrarUsuario("João", "João", "123", "endereco1");
        p1 = clog.adicionarProdutoNoEstoque("Celular", 500.00, "Tecnologia", 10);
        p2 = clog.adicionarProdutoNoEstoque("Bolsa", 700.00, "Roupa", 20);
        p3 = clog.adicionarProdutoNoEstoque("Barra de chocolate", 100.00, "Comida", 50);   
    }

    @Test
    public void testCadastrarUsuario() {
        u1 = ccl.cadastrarUsuario("João", "joao", "123", "Irara");
        assertEquals(u1.getLogin(), "joao");
        Loja loja = Loja.getInstancia();
        assertEquals(loja, u1.getLoja());
    }

    @Test
    public void testFazerLogin() {
        u1 = ccl.cadastrarUsuario("João", "João", "123", "Enderereco1");
        UCliente cliente = ccl.fazerLogin("João", "123");
        assertNotNull(cliente);
        
        u2 = ccl.cadastrarUsuario("Mirela", "Mirela", "123", "Endereco2");
        cliente = ccl.fazerLogin("Mirelaa", "123");
        assertNull(cliente);
        cliente = ccl.fazerLogin("Mirela", "123");
        assertEquals("Mirela", cliente.login);
    }

    @Test
    public void testFecharPedidoFinalizarPedido() {
        UCliente cliente = ccl.fazerLogin("João", "123");
        assertNotNull(cliente);
        
        assertTrue(ccl.adicionarProdutoNoCarrinho(p1, 5));
        assertFalse(ccl.adicionarProdutoNoCarrinho(p2, 50));
        
        Iterator it = ccl.listarProdutosNoCarrinho();
        Itens item = (Itens) it.next();
        assertEquals(p1, item.getProduto());
        assertFalse(it.hasNext());
        
        assertTrue(ccl.adicionarProdutoNoCarrinho(p2, 20));
        Pedido pedido = ccl.fecharPedido();
        assertEquals(16500.00, pedido.valorTotalPedido(), 0.1);
        
        ccl.escolherPagamento(PagamentoStrategy.PIX);
        ccl.realizarPagamento("chavePix"); // O único dado a ser passado para os dados do Pix é a chavePix(do tipo String).
        
        assertEquals(0, ccl.valorCarrinho(), 0.1);
        assertFalse(ccl.adicionarProdutoNoCarrinho(p2, 1));
    }
    
       @Test
    public void testPagamentoPicPay() {
        UCliente cliente = ccl.fazerLogin("João", "123");
        assertTrue(ccl.adicionarProdutoNoCarrinho(p1, 5));       
        assertTrue(ccl.adicionarProdutoNoCarrinho(p2, 20));
        assertTrue(ccl.adicionarProdutoNoCarrinho(p3, 8));
        
        Pedido pedido = ccl.fecharPedido();
        assertEquals(17300.00, pedido.valorTotalPedido(), 0.1);
        
        ccl.escolherPagamento(PagamentoStrategy.PICPAY);
        ccl.realizarPagamento("email@gmail.com", "senha123"); // Os dados a serem passados para o PicPay é email(String) e senha(String).
        
        assertEquals(0, ccl.valorCarrinho(), 0.1);
        assertFalse(ccl.adicionarProdutoNoCarrinho(p3, 100));
    }
    
    @Test
    public void testPagamentoCartao() {
        UCliente cliente = ccl.fazerLogin("João", "123");
        assertTrue(ccl.adicionarProdutoNoCarrinho(p1, 10));       
        assertTrue(ccl.adicionarProdutoNoCarrinho(p2, 20));
        assertTrue(ccl.adicionarProdutoNoCarrinho(p3, 10));
        
        Pedido pedido = ccl.fecharPedido();
        assertEquals(20000.00, pedido.valorTotalPedido(), 0.1);
        
        ccl.escolherPagamento(PagamentoStrategy.CARTAO);
        ccl.realizarPagamento("Nome1", "12345678", "123", "2025"); // Os dados a serem passados para o Cartão é nome, número do cartão, cvv, e ano de vencimento(Todos Strings).
        
        assertEquals(0, ccl.valorCarrinho(), 0.1);
        assertFalse(ccl.adicionarProdutoNoCarrinho(p1, 1));
    }
       
}
