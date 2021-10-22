import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Cidade {
  //tabela com todas as cidades por nome
  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>();

  //nome da cidade
  public String nome;

  //link da cidade adjacente
  public final HashSet<Link> links = new HashSet<Link>();

  //menor distancia
  public int distancia;

  //menor caminho percorrido
  public Link linkPai;

  /* contrutor para Cidade com um nome
   * adicionado a tabela (HashMap) de cidades
   */
  public Cidade(String nm) {
    nome = nm;
    cidades.put(nome, this);
  }

  /* Método para encontrar uma cidade pelo nome
   * retorna a cidade se ela existir na tabela
   * caso contrário retorna uma nova cidade com o nome informado
   */
  public static Cidade encontrar(String nm) {
    Cidade p = cidades.get(nm);
    if (p == null) {
      p = new Cidade(nm);
      return null;
    }
    return p;
  }

  /* adiciona um link entre cidades na lista de links
   */
  public void addLink(Link lnk) {
    links.add(lnk);
  }

  /* compare cidades pelos seus nomes
   * returna negativo se c1 for alfabeticamente anterior,
   *  0 se os nomes forem os menos,
   *  e positivo se c2 for alfabeticamente maior
   */
  public int comparaNome(Cidade p) {
    return p.nome.compareTo(p.nome);
  }

  /* returna o nome da cidade
   */
  public String toString() {
    return nome;
  }

  /* compara cidades pela sua distancia até a rede de trens (ponto 0)
   * returna negativo se c1 for mais próxima, 0 se a distancia for a mesma, e positivo se c2 for mais próxima
   */
  public int comparaDistancia(Cidade c1, Cidade c2) {
    return c1.distancia - c2.distancia;
  }
}
