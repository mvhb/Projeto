import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

    Cidade cidade = new Cidade("Recife");
    Cidade cidadeComecandoComA = new Cidade("Aliança");

    Link link = new Link(cidade, cidadeComecandoComA, 300);

    @Test
    void encontrar() {
        assertEquals(cidade, cidade.encontrar("Recife"), "Não foi retornado o objeto Cidade (Recife)");
        assertEquals("Timbaúba", cidade.encontrar("Timbaúba").toString(), "O objeto criado não retornou o nome da cidade");
    }

    @Test
    void addLink() {
        Link link = new Link(cidadeComecandoComA, cidade, 300);
        assertEquals(2, cidade.links.size(), "O link não foi criado corretamente");
    }

    @Test
    void comparaNome() {
        //lembrar de add os comentarios de erro
        assertTrue(cidade.comparaNome(cidadeComecandoComA) > 0, "Não está retornando positivo quando C1 é maior");
        assertEquals(0, cidade.comparaNome(cidade), "Não está retonando 0 quando C1 e C2 são iguais");
        assertTrue(cidadeComecandoComA.comparaNome(cidade) < 0, "Não está retornando negativo quando C1 é menor");
    }

    @Test
    void testToString() {
        assertEquals("Recife", cidade.toString(), "O nome retornado não é igual ao nome da cidade do objeto chamado");
    }

    @Test
    void comparaDistancia() {
    //deixou de fazer sentido após a refatoração do ComparadorCidade
    }
}