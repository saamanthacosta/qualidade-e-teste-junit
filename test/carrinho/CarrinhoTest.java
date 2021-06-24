package carrinho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoTest {

    private Carrinho carrinho;
    private final Produto celular = new Produto("celular", 100.99);
    private final Produto capinha = new Produto("capinha", 20);

    @BeforeEach
    public void setup() {
        carrinho = new Carrinho();
    }

    @Test
    public void testAdicionarItem() {
        assertTrue(carrinho.getQtdeItems() == 0);
        carrinho.addItem(new Produto("capinha", 20));
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    public void testRemoverItem() {
        carrinho.addItem(capinha);
        carrinho.addItem(celular);
        assertEquals(2, carrinho.getQtdeItems());
        carrinho.removeItem(capinha);
        assertTrue(carrinho.getQtdeItems() == 1);
    }

    @Test
    public void testEsvaziarCarrinho() {
        carrinho.addItem(capinha);
        carrinho.addItem(capinha);
        carrinho.addItem(celular);
        carrinho.addItem(celular);
        assertEquals(4, carrinho.getQtdeItems());
        carrinho.esvazia();
        assertTrue(carrinho.getQtdeItems() == 0);
    }

    @Test
    public void testValorTotal() {
        carrinho.addItem(capinha);
        carrinho.addItem(capinha);
        assertEquals(2*capinha.getPreco(), carrinho.getValorTotal());
    }

    @Test
    public void testValorTotalCarrinhoVazio() {
        assertTrue(carrinho.getValorTotal() == 0);
    }

}