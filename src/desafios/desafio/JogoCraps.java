package desafios.desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JogoCraps {
  public static void jogar() {
    int rodada = 0;
    int seuPonto = 0;
    //Lembra da etapa da decomposição e abstração?
    List<Integer> natural = Arrays.asList(7, 11); //Valores que representa o NATURAL na primeira rodada - GANHA
    List<Integer> craps = Arrays.asList(2, 3, 12); //Valores que representa o CRAPS na primeira rodada - PERDE
    List<Integer> ponto = Arrays.asList(4, 5, 6, 8, 9, 10); //Valores que representa seu ponto nas demais rodads

    do { //faça
      rodada++; //Marca a rodada atual
      int dado1 = gerarValorDado(); //lançamento dado 1
      int dado2 = gerarValorDado(); //lançamento dado 2
      int somaDados = dado1 + dado2; //soma dos dados

      if (rodada == 1) { //Primeiramente, testando as regras para a rodada 1.
        if (natural.contains(somaDados)) { //Se a soma dos dados for um natural, você ganha.
          System.out.printf("RODADA = %d\n\nVocê tirou %d na rodada %d\nVocê é um NATURAL!\n", rodada, somaDados, rodada);
          System.out.println("**** GANHOU ****");
          break;
        } else if (craps.contains(somaDados)) { //Se a soma dos dados for um Craps, você perde
          System.out.printf("RODADA = %d\n\nVocê tirou %d na rodada %d = CRAPS\n", rodada, somaDados, rodada);
          System.out.println("**** PERDEU ****");
          break;
        } else { //Se não, a soma dos dados é seu ponto e você continua jogando.
          seuPonto = somaDados;
        }
      } else { //Testando as regras para as demais rodas
        if (somaDados == seuPonto) { //Se a soma dos dados for igual ao seu ponto (definido na primeira rodada), você ganha.
          System.out.printf("RODADA = %d\n\nSeu ponto %d é igual soma dos dados %d\n", rodada, seuPonto, somaDados);
          System.out.println("**** GANHOU ****");
          break;
        } else if (somaDados == 7) { //Se a soma dos dados for igual a 7, antes de tirar seu ponto novamente, você ganha.
          System.out.printf("RODADA = %d\n\nVocê tirou %d na rodada %d\n", rodada, somaDados, rodada);
          System.out.println("**** PERDEU ****");
          break;
        } else { //Caso não contemple os dos if's anteriores, você continua lançando os dados.
          continue;
        }
      }
    } while (true); //Enquanto o laço não é interrompido pelo break.
  }

  private static int gerarValorDado() { //método de geração dos valor do dado
    Random random = new Random(); //Classe que faz a geração de números aleatórios no Java.
    return random.nextInt(6) + 1; //função que gera um número aleatório entre 1 e 6. (Valores possíveis de um dado)
  }
}

