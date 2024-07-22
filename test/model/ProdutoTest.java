/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
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
