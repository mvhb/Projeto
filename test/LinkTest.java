import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    Cidade cidade = new Cidade("Recife");
    Cidade cidadeComecandoComA = new Cidade("Aliança");
    Cidade cidadeComecandoComC = new Cidade("Caicó");
    Cidade cidadeComecandoComE = new Cidade("Estancia");

    Link link = new Link(cidade, cidadeComecandoComA, 100);
    //Aliança passa a ser c1 e Recife c2

    Link link2 = new Link(cidadeComecandoComA, cidadeComecandoComC, 100);
    Link link3 = new Link(cidadeComecandoComC, cidadeComecandoComE, 100);
    Link link4 = new Link(cidade, cidade, 0);
    Link link5 = new Link(cidadeComecandoComA, cidade, 300);

    @Test
    void getDistancia() {
        assertEquals(100,link.getDistancia(), "Distancia do link incorreta");
    }

    @Test
    void isUsado() {
        assertTrue(link.isUsado(), "Não esta sendo reconhecido o link");
    }

    @Test
    void setUsado() {
        link.setUsado(false);
        assertFalse(link.isUsado(), "setUsado não está retornando o boleano corretamente");
    }

    @Test
    void testToString() {
        assertEquals("Aliança 100 Recife", link.toString(), "Retorno diferente de Aliança 100 Recife");
    }

    @Test
    void compareTo() {
        assertEquals(0, link.compareTo(link), "Nao esta retornando 0 para link iguais");
        assertEquals(-1, link2.compareTo(link4), "Nao esta retornando negativo para this.cidade1 < l.cidade1 (Alfabetcamente)");
        assertEquals(-1, link.compareTo(link2), "Nao esta retornando negativo se cidade1 é igual nos dois links");
        assertEquals(-1, link3.compareTo(link5), "Nao esta retornando negativo se this.cidade2 < l.cidade2 (Alfabetcamente)");
        assertEquals(1, link4.compareTo(link), "Nao esta retornando positivo caso this.c1 e this.c2 seja maior (Alfabeticamente");
    }
}