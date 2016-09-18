package net.xaviersala;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LlargadaTest {

    Llargada llargada;

    @Before
    public void setup() {
        llargada = new Llargada();
    }
    @Test
    public void testLlargadaZero() {
        assertEquals("Ha de donar res", "", llargada.calcula(""));
    }

    @Test
    public void testUnCaracter() {
        assertEquals("Un caràcter ha de donar 1", "a 1", llargada.calcula("a"));
    }

    @Test
    public void testDosCaracters() {
        assertEquals("Dos caràcters es compten", "a,b 1", llargada.calcula("ab"));
    }


    @Test
    public void testMesCaracters() {
        assertEquals("Dos caràcters es compten", "a,b,c,d,e 1", llargada.calcula("abcde"));
    }

    @Test
    public void testDosCaractersRepetits() {
        assertEquals("Dos caràcters es compten", "a,b 2", llargada.calcula("aabb"));
        assertEquals("Dos caràcters es compten", "a,b 2", llargada.calcula("cdeaabb"));
        assertEquals("Dos caràcters es compten", "a,b 2", llargada.calcula("aabbc"));
    }

    @Test
    public void testDosCaractersAmbPallaAlMig() {
        assertEquals("Dos caràcters es compten", "a,b 2", llargada.calcula("aacadbebb"));
    }


    @Test
    public void testRepeticioAlPrincipi() {
        assertEquals("Es repeteix al principi", "a 3", llargada.calcula("aaabcde"));
    }
    @Test
    public void testRepeticioAlFinal() {
        assertEquals("No calcula la repetició final", "b 2", llargada.calcula("abcdbb"));
    }

    @Test
    public void testRepeticioAlMig() {
        assertEquals("Es repeteix al mig", "b,c 2", llargada.calcula("abbdeccd"));
    }

    @Test
    public void testRepeticioMultiple() {
        assertEquals("Repetició múltiple", "a 5", llargada.calcula("aaaaa"));
        assertEquals("Repetició múltiple", "a 5", llargada.calcula("aaaaab"));
        assertEquals("Repetició múltiple", "a 5", llargada.calcula("baaaaa"));
        assertEquals("Repetició múltiple", "a,b 5", llargada.calcula("aaaaabbbbb"));
    }

    @Test
    public void testRepeticioMultipleRepetida() {
        assertEquals("Repeticio Múltiple de diversos caràcters", "a,b 5", llargada.calcula("caaaaafebbbbbe"));
        assertEquals("Repeticio Múltiple de diversos caràcters al final", "a,b 5", llargada.calcula("caaaaafebbbbb"));
        assertEquals("Repeticio Múltiple de diversos caràcters al principi", "a,b 5", llargada.calcula("aaaaafebbbbbe"));
    }


}
