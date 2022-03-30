/* Classe que trata da construção de links entre as cidades
 */
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int distancia; // alterado de 'tamanho' pra 'distancia'
  public boolean usado = false;

  /* Dado que duas cidades sao recebidas
   * o método construtor cria um Link entre a primeira cidade e a segunda cidade com um tamanho específico
   * As cidades são comparadas ALFABETICAMENTE e criadas no link em ordem alfabética
   * o link é criado entre as duas cidades
   * Exemplo de comparação Alfabética entre cidades: Camaragibe>Recife, porque C vem antes de R
   */
  public Link(Cidade c1, Cidade c2, int distancia) { // alterado o parametro de 'tam' pra 'distancia'
    if (c1.comparaNome(c2) < 0) {
      cidade1 = c1;
      cidade2 = c2;
    } else {
      cidade1 = c2;
      cidade2 = c1;
    }
    this.distancia = distancia;
    c1.addLink(this);
    c2.addLink(this);
		usado = true;
  }

  /* retorna o tamanho de um link entre duas cidades */
  public int getDistancia() { //mudando o nome do metodo de "getTamanho" pra "getDistancia"
    return this.distancia; //alterando de cidade1 para this, dado que o objetivo é a pegar a distancia do link e nao da cidade
  }

  /* retorna true se o link entre duas cidades existir */
  public boolean isUsado() {
    return usado;
  }

  /* seta usado como true ou false a depender de o link ser criado ou não */
  public void setUsado(boolean u) {
    usado = false;
  }

  /* returna uma string com a descrição de um Link entre cidades.
   * exemplo Link formado por Cidade1, tamanho 3 e Cidade2, retorna "Cidade1 3 Cidade2".
   */
  public String toString() {

    return cidade1.toString()+ " " + this.distancia + " "  + cidade2.toString(); // alterado para adicionar a distancia, antes tava vazio
  }

  /* Compara dois links para saber o que eles tem em comum
   * returna 0 se os links tiverem as mesmas cidade1 e cidade2
   * returna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
   * retorna negativo se cidade1 é igual nos dois links
   * retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
   * retorna positivo caso contrário
   * Exemplo: Link1: Recife 3 Olinda / Link2: Recife 2 Camaragibe
   * Link1.compareTo(Link2) -> Resultado: retorna negativo, porque cidade1 é Recife e é igual nos dois Links
   */
  public int compareTo(Link l) { // foi alterada a logica da funcao, onde foi preciso criar um novo elif e separar validacoes em conjunto

    if(cidade1==l.cidade1 && cidade2==l.cidade2)
      return 0;
    else if (cidade1==l.cidade1){
      return -1;
    }
    else if((cidade1.comparaNome(l.cidade1)<0)
            || cidade2.comparaNome(l.cidade2)<0)
      return -1;
    else
      return +1;
  }
}
