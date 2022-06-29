import java.util.HashMap;
import java.util.Map;

public class Aluno {

  private String nome;

  Map<Prova, Double> provas = new HashMap<Prova, Double>();

  Map<Trabalho, Double> trabalhos = new HashMap<Trabalho, Double>();

  public Aluno(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public double getNotaOfProva(Prova prova) {
    return provas.get(prova);
  }

  public double getNotaOfTrabalho(Trabalho trabalho) {
    return trabalhos.get(trabalho);
  }

  public void addProva(Prova prova, double nota) {
    provas.put(prova, nota);
  }

  public void addTrabalho(Trabalho trabalho, double nota) {
    trabalhos.put(trabalho, nota);
  }

  private double sum(double[] values) {
    double sum = 0;
    for (double value : values) {
      sum += value;
    }
    return sum;
  }

  private double mediaPonderada(double[] valores, double[] pesos) {
    double soma = 0;
    for (int i = 0; i < valores.length; i++) {
      soma += valores[i] * pesos[i];
    }
    return soma / sum(pesos);
  }

  public double getMedia() {
    double[] notas = new double[provas.size() + trabalhos.size()];
    double[] pesos = new double[provas.size() + trabalhos.size()];
    int i = 0;
    for (Prova prova : provas.keySet()) {
      notas[i] = provas.get(prova);
      pesos[i] = prova.getPeso();
      i++;
    }
    for (Trabalho trabalho : trabalhos.keySet()) {
      notas[i] = trabalhos.get(trabalho);
      pesos[i] = trabalho.getPeso();
      i++;
    }
    return mediaPonderada(notas, pesos);
  }
}
