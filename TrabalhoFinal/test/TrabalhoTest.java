import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TrabalhoTest {
    @Test
    public void testTrabalho() {
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        assertEquals("Trabalho 1", trabalho.getNome());
        assertEquals(0.5, trabalho.getPeso());
    }

    @Test
    public void testGetNome() {
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        assertEquals("Trabalho 1", trabalho.getNome());
    }

    @Test
    public void testGetPeso() {
        Trabalho trabalho = new Trabalho("Trabalho 1", 0.5);
        assertEquals(0.5, trabalho.getPeso());
    }
}
