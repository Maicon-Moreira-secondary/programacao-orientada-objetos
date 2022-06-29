import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AlunoTest {
    @Test
    public void testAluno() {
        Aluno aluno = new Aluno("João");
        assertEquals("João", aluno.getNome());
    }

    @Test
    public void testGetNome() {
        Aluno aluno = new Aluno("João");
        assertEquals("João", aluno.getNome());
    }

    @Test
    public void testGetNotaOfProva() {
        Aluno aluno = new Aluno("João");
        Prova prova = new Prova("Prova 1", 0.5);
        aluno.addProva(prova, 10.0);
        assertEquals(10.0, aluno.getNotaOfProva(prova));
    }

    @Test
    public void testGetNotaOfTrabalho() {
        Aluno aluno = new Aluno("João");
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        aluno.addTrabalho(trabalho, 10.0);
        assertEquals(10.0, aluno.getNotaOfTrabalho(trabalho));
    }

    @Test
    public void testAddProva() {
        Aluno aluno = new Aluno("João");
        Prova prova = new Prova("Prova 1", 0.5);
        aluno.addProva(prova, 10.0);
        assertEquals(10.0, aluno.getNotaOfProva(prova));
    }

    @Test
    public void testAddTrabalho() {
        Aluno aluno = new Aluno("João");
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        aluno.addTrabalho(trabalho, 10.0);
        assertEquals(10.0, aluno.getNotaOfTrabalho(trabalho));
    }

    @Test
    public void testGetMedia() {
        Aluno aluno = new Aluno("João");
        Prova prova = new Prova("Prova 1", 0.5);
        aluno.addProva(prova, 10.0);
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        aluno.addTrabalho(trabalho, 10.0);
        assertEquals(10.0, aluno.getMedia());
    }
}