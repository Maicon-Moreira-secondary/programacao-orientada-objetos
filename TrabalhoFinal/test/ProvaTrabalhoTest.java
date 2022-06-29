import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProvaTrabalhoTest {
    @Test
    public void testProvaTrabalho() {
        ProvaTrabalho provaTrabalho = new ProvaTrabalho("Prova 1", 0.5);
        assertEquals("Prova 1", provaTrabalho.getNome());
        assertEquals(0.5, provaTrabalho.getPeso());
    }

    @Test
    public void testGetNome() {
        ProvaTrabalho provaTrabalho = new ProvaTrabalho("Prova 1", 0.5);
        assertEquals("Prova 1", provaTrabalho.getNome());
    }

    @Test
    public void testGetPeso() {
        ProvaTrabalho provaTrabalho = new ProvaTrabalho("Prova 1", 0.5);
        assertEquals(0.5, provaTrabalho.getPeso());
    }
}
