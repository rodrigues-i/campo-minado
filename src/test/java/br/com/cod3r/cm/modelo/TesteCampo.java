package br.com.cod3r.cm.modelo;

import br.com.cod3r.cm.modelo.Campo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

// importa tudo dentro da classe Assertions
// import static org.junit.jupiter.api.Assertions.*;

public class TesteCampo {

	private Campo campo;
	
	// a anotação 'BeforeEach' indica que o método deve ser executado antes de cada teste
	@BeforeEach	
	void iniciarCampo() {
		this.campo =  new Campo(3,3);
	}

	@Test
	void testeVizinhoDistancia1Esquerda() {
		Campo vizinho = new Campo(3,2);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertTrue(resultado);

	}

	@Test
	void testeVizinhoDistancia1Direita() {
		Campo vizinho = new Campo(3,4);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmCima() {
		Campo vizinho = new Campo(2,3);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia1EmBaixo() {
		Campo vizinho = new Campo(4,3);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertTrue(resultado);
	}

	@Test
	void testeVizinhoDistancia2() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1,1);
		boolean resultado = campo.adicionarVizinho(vizinho);

		assertFalse(resultado);
	}

	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();

		assertTrue(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();

		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();

		assertFalse(campo.abrir());
	}

}