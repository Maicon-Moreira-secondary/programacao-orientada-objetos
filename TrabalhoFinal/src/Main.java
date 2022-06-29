public class Main {

  public static void main(String[] args) {
    Prova[] provas = { new Prova("Prova 1", 1), new Prova("Prova 2", 1.5) };
    Trabalho[] trabalhos = {
      new Trabalho("Trabalho 1", 2.75),
      new Trabalho("Trabalho 2", 2.25),
    };

    Aluno[] alunos = {
      new Aluno("Ana"),
      new Aluno("Bia"),
      new Aluno("Carlos"),
      new Aluno("Daniel"),
      new Aluno("Eduardo"),
      new Aluno("Fabio"),
      new Aluno("Gabriel"),
      new Aluno("Heitor"),
      new Aluno("Igor"),
      new Aluno("Joao"),
      new Aluno("Jose"),
      new Aluno("Lucas"),
      new Aluno("Mateus"),
      new Aluno("Natalia"),
      new Aluno("Pedro"),
      new Aluno("Rafael"),
      new Aluno("Samuel"),
      new Aluno("Thiago"),
      new Aluno("Vinicius"),
    };

    adicionarProvasETrabalhosComNotasAleatorias(alunos, provas, trabalhos);

    // mostrar notas de cada prova e trabalho
    for (Aluno aluno : alunos) {
      System.out.println("Notas de " + aluno.getNome());
      for (Prova prova : provas) {
        System.out.println(
          "   " + prova.getNome() + ": " + aluno.getNotaOfProva(prova)
        );
      }
      for (Trabalho trabalho : trabalhos) {
        System.out.println(
          "   " + trabalho.getNome() + ": " + aluno.getNotaOfTrabalho(trabalho)
        );
      }
    }

    // mostrar medias de cada aluno
    for (Aluno aluno : alunos) {
      System.out.format(
        "Media final de %s: %.2f\n",
        aluno.getNome(),
        aluno.getMedia()
      );
    }
  }

  private static double notaAleatoria() {
    return ((double) (int) (Math.random() * 100)) / 10;
  }

  private static void adicionarProvasETrabalhosComNotasAleatorias(
    Aluno[] alunos,
    Prova[] provas,
    Trabalho[] trabalhos
  ) {
    for (Aluno aluno : alunos) {
      for (Prova prova : provas) {
        aluno.addProva(prova, notaAleatoria());
      }
      for (Trabalho trabalho : trabalhos) {
        aluno.addTrabalho(trabalho, notaAleatoria());
      }
    }
  }
}
