import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Cidade {
  //tabela com todas as cidades por nome
  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>();

  //nome da cidade
  public String nome;

  //nome da cidade
  //public String nomedacidade = "Varginha";  --> variavel duplicada, foi removida

  //link da cidade adjacente (cidade próxima)
  public final HashSet<Link> links = new HashSet<Link>();

  //menor distancia
  public int distancia;

  /* contrutor para Cidade com um nome
   * adicionado a tabela (HashMap) de cidades
   */
  public Cidade(String nome) { //mudando o parametro de "nm" para "nome" - por legibilidade
    this.nome = nome;
    cidades.put(nome, this);
  }

  /* Método para encontrar uma cidade pelo nome
   * retorna a cidade se ela existir na tabela (HashMap)
   * caso contrário retorna uma nova cidade com o nome informado
   */
  public static Cidade encontrar(String nome) { //mudando o parametro de "nm" para "nome" - por legibilidade
    Cidade cidadeEncontrada = cidades.get(nome); //trocando o nome de "p" para "cidadeEncontrada" - por legibilidade
    if (cidadeEncontrada == null) {
      Cidade novaCidade = new Cidade(nome); //trocando o nome de "p" para "novaCidade" - por legibilidade
      return novaCidade; //trocando o retorno pra o objeto (antes era null)
    }
    return cidadeEncontrada;
  }

  /* adiciona um link entre duas cidades na lista de links
   * Exemplo: Para criar um link entre Recife e Olinda eu preciso adicionar pelo pelos as cidades de Recife e Olinda
   */
  public void addLink(Link lnk) {
    links.add(lnk);
  }

  /* compare cidades pelos seus nomes
   * returna negativo se c1 for alfabeticamente menor,
   *  0 se os nomes forem os mesmos,
   *  e positivo se c2 for alfabeticamente menor
   * Exemplo: c1=Recife / c2=Olinda - return positivo, porque Olinda é menor que Recife, porque O vem antes de R.
   */
  public int comparaNome(Cidade cidade2) {
    return this.nome.compareTo(cidade2.nome); //alterando a comparação para pegar c1 e c2, antes tava passando as mesmas cidades sempre
  }

  /* retorna a String do nome de uma cidade. Por exemplo cidade1.ToString retorna "Recife", se o objeto da classe cidade for Recife
   */
  public String toString() {
    return nome;
  }

  /* compara duas cidades pela sua distancia até um ponto específico
   * returna negativo se c1 for mais próxima do ponto, 0 se a distancia for a mesma, e positivo se c2 for mais próxima do ponto
   * Por exemplo:
   * - Ponto específico: Praia de Boa Viagem
   * - c1= Recife
   * - c2 = Maceió
   * - return negativo (-1), pois Recife é mais próxima do ponto de referencia: Boa Viagem.
   */

  // public int comparaDistancia(Cidade c1, Cidade c2) {    ---> metodo foi comentado pois não faz sentido a sua utilizacao
  //   return c1.distancia - c2.distancia;
  // }
}
