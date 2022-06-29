import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProvaTest {
    @Test
    public void testProva() {
        Prova prova = new Prova("Prova 1", 0.5);
        assertEquals("Prova 1", prova.getNome());
        assertEquals(0.5, prova.getPeso());
    }

    @Test
    public void testGetNome() {
        Prova prova = new Prova("Prova 1", 0.5);
        assertEquals("Prova 1", prova.getNome());
    }

    @Test
    public void testGetPeso() {
        Prova prova = new Prova("Prova 1", 0.5);
        assertEquals(0.5, prova.getPeso());
    }
}
