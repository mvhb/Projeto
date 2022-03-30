import java.util.Comparator;

/* Compare two cidades for use in sorting or data structures
 */ 
public class ComparadorCidade {
  /* compara duas cidades pela sua distancia até um ponto específico
   * returna negativo se c1 for mais próxima do ponto, 0 se a distancia for a mesma, e positivo se c2 for mais próxima do ponto
   * Por exemplo:
   * - Ponto específico: Praia de Boa Viagem
   * - c1= Recife
   * - c2 = Maceió
   * - return negativo (-1), pois Recife é mais próxima do ponto de referencia: Boa Viagem.
   */
  public int compare(Cidade cidade1, Cidade cidade2) {

    int distancia1 = cidade1.distancia;
    int distancia2 = cidade2.distancia;

    if(distancia1 == distancia2){
      return 0;
    } else if (distancia1 < distancia2){
      return -1;
    }else {
      return +1;
    }
  }
}
