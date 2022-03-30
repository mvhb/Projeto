import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCidadeTest {

    @Test
    void compare() {
        Cidade olinda = new Cidade("Olinda");
        Cidade saoMiguelDosMilagres = new Cidade("São Miguel dos Milagres");

        ComparadorCidade comparadorCidade = new ComparadorCidade();

        olinda.distancia = 10; //Referencia Recife
        saoMiguelDosMilagres.distancia = 202; // Referencia Recife

        assertEquals(-1, comparadorCidade.compare(olinda, saoMiguelDosMilagres), "Não retornou -1 quando c1 é mais perto da referencia");
        assertEquals(+1, comparadorCidade.compare(saoMiguelDosMilagres, olinda), "Não retornou +1 quando c2 é mais perto da referencia" );
        assertEquals(0, comparadorCidade.compare(saoMiguelDosMilagres, saoMiguelDosMilagres), "Não retornou 0 quando de c1 e c2 tem a mesma distancia para a referencia");
    }
}