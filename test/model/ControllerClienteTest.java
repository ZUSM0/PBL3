package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerClienteTest {
    
    private UCliente u1, u2;
    private ControllerCliente ccl = new ControllerCliente();
    
    public ControllerClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        u1 = ccl.cadastrarUsuario("João", "João", "123", "endereco1");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCadastrarUsuario() {
        u1 = ccl.cadastrarUsuario("João", "joao", "123", "Irara");
        assertEquals(u1.getLogin(), "joao");
        Loja loja = Loja.getInstancia();
        assertEquals(u1.loja, loja);
    }

    /**
     * Test of fazerLogin method, of class ControllerCliente.
     */
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
    public void testFecharPedido() {
        UCliente cliente = ccl.fazerLogin("João", "123");
        assertNotNull(cliente);
        
        
    }
       
}
