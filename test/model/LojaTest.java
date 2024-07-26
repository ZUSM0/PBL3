/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LojaTest {
    Loja loja = Loja.getInstancia();
    private UCliente u1;
    private Produto p1, p2, p3;
    
    public LojaTest() {
    }
    
    @Before
    public void setUp() {
        u1 = new UCliente("Joao", "João", "123", "endereco1");
        p1 = new Produto(50.0, "tecnologia", "PS2", 50);
        p2 = new Produto(50.0, "Roupa", "Camisa", 50);
        p3 = new Produto(50.0, "comida", "Sorvete", 50);
    }

    @Test
    public void testCadastrarClienteELogin() {
        assertTrue(loja.cadastrarCliente(u1));
        assertFalse(loja.cadastrarCliente(u1));
        Iterator iterator = loja.listarClientes();
        assertEquals(u1, iterator.next());
        assertFalse(iterator.hasNext());
        
        assertNull(loja.fazerLogin("Joao", "123"));
        assertNotNull(loja.fazerLogin("João", "123"));
    }

}
