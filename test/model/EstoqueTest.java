/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Iterator;
import model.Composite.EstoqueComposite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EstoqueTest {
    Estoque estoque;
    Produto p1, p2, p3;
    
    public EstoqueTest() {
    }
    
    @Before
    public void setUp() {
        estoque = Estoque.getInstancia();
        p1 = new Produto(500.00, "Tecnologia", "Celular", 10);
        p2 = new Produto(700.00, "Roupa", "Bolsa", 20);
        p3 = new Produto(100.00, "Comida", "Barra de chocolate", 50);
        
    }

    @Test
    public void testSingletonEstoque() {
        Estoque estoque1 = Estoque.getInstancia();
        Estoque estoque2 = Estoque.getInstancia();
        
        assertEquals(estoque, estoque1);
        assertEquals(estoque, estoque2);
    }

    @Test
    public void testAdicionarProdutoNoEstoque() {
        estoque.adicionarProdutoNoEstoque(p1);
        estoque.adicionarProdutoNoEstoque(p2);
        estoque.adicionarProdutoNoEstoque(p3);
        
        Iterator it = estoque.listarProdutoNoEstoque();
        assertEquals(p1, it.next());
        assertEquals(p2, it.next());
        
        Produto produto = (Produto) it.next();
        assertEquals(p3, produto);
        
        assertEquals("Comida", produto.getTipo());
        Produto p4 = new Produto(900.00, "Comida", "Macarrão", 30);
        estoque.adicionarProdutoNoEstoque(p4);
        
        Iterator itCategoria = estoque.listarProdutoNoEstoque("Comida");
        produto = (Produto) itCategoria.next();
        assertEquals(p3, produto);
        produto = (Produto) itCategoria.next();
        assertEquals("Macarrão", produto.getDescricao());
        
        Produto p5 = new Produto(1200.00, "Roupa", "Sandalia", 5);
        estoque.adicionarProdutoNoEstoque(p5);
        itCategoria = estoque.listarProdutoNoEstoque("Roupa");
        produto = (Produto) itCategoria.next();
        assertEquals(p2, produto);
        produto = (Produto) itCategoria.next();
        assertEquals("Sandalia", produto.getDescricao());
    }

    @Test
    public void testRemoverProdutoNoEstoque() {
        estoque.adicionarProdutoNoEstoque(p1);
        estoque.adicionarProdutoNoEstoque(p2);
        estoque.adicionarProdutoNoEstoque(p3);
        
        assertTrue(estoque.removerProdutoNoEstoque(p1));
        assertFalse(estoque.removerProdutoNoEstoque(p1));
        
    }
    
}
