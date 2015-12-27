package novi;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void shouldBeAbleToInitiateGridWithAPattern() {
        String allPositive = "+ +\n"
                           + "+ +";
        Grid grid = new Grid(allPositive);
        assertEquals("+ +\n" +
                     "+ +", grid.display());

        String allNegative = "- -\n"
                           + "- -";
        grid = new Grid(allNegative);
        assertEquals("- -\n" +
                     "- -", grid.display());
    }

    @Test
    public void shouldBeAbleToSendAPulseAndChangeAGenerationForBlinkerPattern() {
        String blinkerPattern = "- - -\n" +
                               "+ + +\n" +
                               "- - -";
        Grid grid = new Grid(blinkerPattern);
        assertEquals("- + -\n" +
                     "- + -\n" +
                     "- + -", grid.nextGeneration().display());
    }

    @Test
    public void shouldBeAbleToSendAPulseAndChangeAGenerationForToadPattern() {
        String blinkerPattern = "- - - -\n" +
                                "- + + +\n" +
                                "+ + + -\n" +
                                "- - - -" ;
        Grid grid = new Grid(blinkerPattern);
        assertEquals("- - + -\n" +
                     "+ - - +\n" +
                     "+ - - +\n" +
                     "- + - -" , grid.nextGeneration().display());
    }
}
