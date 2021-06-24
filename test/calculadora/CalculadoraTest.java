package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Excessão não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	@Test
	public void testSubtracaoDoisNumerosPositivos() {
		assertEquals(5, calc.subtracao(10, 5));
		assertEquals(-5, calc.subtracao(5, 10));
	}

	@Test
	public void testSoma() {
		assertEquals(20, calc.somatoria(6));
	}

	@Test
	public void testSomaZero() {
		assertEquals(0, calc.somatoria(0));
	}

	@Test
	public void testSomaNegativo() {
		assertEquals(0, calc.somatoria(-9));
	}

	@Test
	public void testSubtracaoNumerosNegativos() {
		assertEquals(5, calc.subtracao(-5, -10));
	}

	@Test
	public void testSubtracaoUmNumeroNegativo() {
		assertEquals(-15, calc.subtracao(-5, 10));
	}

	@Test
	public void testMultiplicacao() {
		assertEquals(16, calc.multiplicacao(2, 8));
		assertEquals(16, calc.multiplicacao(-2, -8));
	}

	@Test
	public void testMultiplicacaoNegativo() {
		assertEquals(-24, calc.multiplicacao(3, -8));
	}

	@Test
	public void testMultiplicacaoZero() {
		assertEquals(0, calc.multiplicacao(8246, 0));
	}

	@Test
	public void testDivisaoNegativos() {
		assertEquals(-2, calc.divisao(10, -5));
		assertEquals(2, calc.divisao(-10, -5));
	}

	@Test
	public void testPositivoTrue() {
		assertTrue(calc.ehPositivo(4));
	}

	@Test
	public void testPositivoFalse() {
		assertFalse(calc.ehPositivo(-4));
	}


}
