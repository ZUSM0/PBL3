package model;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UClienteTest {
    UCliente cliente;
    Produto produto, produto1, produto2;
    public UClienteTest() {
    }
    
    @Before
    public void setUp() {
        cliente = new UCliente("Joao", "João", "123", "endereco1");
        produto = new Produto(50.0, "tecnologia", "PS2", 50);
        produto1 = new Produto(50.0, "Roupa", "Camisa", 50);
        produto2 = new Produto(50.0, "comida", "Sorvete", 50);
    }
    
   @Test
    public void testAdicionarProdutoNoCarrinho() {
        cliente.adicionarProdutoNoCarrinho(produto, 5);
        Iterator<Itens> iterator = cliente.getCarrinho();
        assertEquals(iterator.next().getProduto(), produto);
        
    }

    @Test
    public void testRemoverProdutoNoCarrinho() {        
        cliente.adicionarProdutoNoCarrinho(produto, 5); // Lembrar de colocar limitação de quantidade
        cliente.adicionarProdutoNoCarrinho(produto2, 5);
        Iterator<Itens> iterator = cliente.getCarrinho();
        assertEquals(iterator.next().getProduto(), produto);

        Boolean popClient = cliente.removerProdutoNoCarrinho(produto2);
        assertTrue(popClient);
        
        popClient = cliente.removerProdutoNoCarrinho(produto1);
        assertFalse(popClient);
    }

    @Test
    public void testFecharPedido() {
        cliente.adicionarProdutoNoCarrinho(produto, 2);
        cliente.adicionarProdutoNoCarrinho(produto1, 5);
        cliente.adicionarProdutoNoCarrinho(produto2, 3);
        assertEquals(500.00, cliente.calcularCarrinho(), 0.1);
        
        cliente.removerProdutoNoCarrinho(produto);
        assertEquals(400.00, cliente.calcularCarrinho(), 0.1);
        
        assertTrue(cliente.listarProdutosNoCarrinho().hasNext());
        double valorCarrinho = cliente.fecharPedido();
        assertEquals(400.00, valorCarrinho,0.1);
        assertFalse(cliente.listarProdutosNoCarrinho().hasNext());
    }
}
