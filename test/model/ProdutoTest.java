package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoTest {
    
    public ProdutoTest() {
    }
    
    @Before
    public void setUp() {
    }
    @Test
    public void testCriarProduto(){
        Produto produto = new Produto(30.90, "tecnologia", "PS5", 100);
        Assert.assertEquals(produto.getPreco(), 30.90, 0.1);
       
    }
    
}
