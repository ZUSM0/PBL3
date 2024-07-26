package model;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerLogistaTest {
    private ControllerLogista clog = new ControllerLogista();
    private ControllerCliente cc = new ControllerCliente();
    private UCliente u1, u2, u3;
    
    public ControllerLogistaTest(){
    }

    @Before
    public void setUp() {
        u1 = cc.cadastrarUsuario("pessoa1", "pessoa1", "123", "endereco1");
        u2 = cc.cadastrarUsuario("pessoa2", "pessoa2", "123", "endereco2");
        u3 = cc.cadastrarUsuario("pessoa3", "pessoa3", "123", "endereco3");
    }

    @Test
    public void testFazerLoginLogista() {
        assertFalse(clog.fazerLoginLogista("cliente", "1234"));
        assertTrue(clog.fazerLoginLogista("logista", "123"));       
    }

    @Test
    public void testAdicionarERemoverProdutoNoEstoque() {
        Produto p1 = clog.adicionarProdutoNoEstoque("Notebook", 15000.00, "Tecnologia", 100);
        Iterator it = clog.listarProdutoNoEstoque();
        Produto produto = (Produto) it.next();
        
        assertEquals(p1, produto);
        assertFalse(it.hasNext());
        
        Produto p2 = clog.adicionarProdutoNoEstoque("Tablet", 1000.0, "Tecnologia", 25);
        Produto p3 = clog.adicionarProdutoNoEstoque("relogio", 5000.0, "Tecnologia", 300);
        it = clog.listarProdutoNoEstoque();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        
        produto = (Produto) it.next();
        assertEquals(p3, produto);
        assertFalse(it.hasNext());
        
        
        assertTrue(clog.removerProdutoNoEstoque(p2));
        it = clog.listarProdutoNoEstoque();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext()); 
    } 
    
    @Test
    public void testListarClientes() {
        Iterator<UCliente> iterator = clog.listarClientesLoja();
        assertEquals(u1, iterator.next());
        assertEquals(u2, iterator.next());
        assertEquals(u3, iterator.next());
        
        assertFalse(iterator.hasNext());
    }

}
