package novi;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CellTest {
    @Test
    public void shouldBeAbleToFindState() {
        Cell liveCell = new Cell("+");
        Cell deadCell = new Cell("-");
        assertTrue(liveCell.isAlive());
        assertFalse(deadCell.isAlive());
    }

    @Test
    public void shouldDisplayState() {
        Cell liveCell = new Cell("+");
        Cell deadCell = new Cell("-");
        assertEquals("+",liveCell.display());
        assertEquals("-",deadCell.display());
    }

    @Test
    public void shouldDieInTheNextGenerationIfThereAreLessThanTwoLiveNeighbours() {
        Cell liveCell = new Cell("+");
        assertFalse(liveCell.nextGeneration().isAlive());

        addNeighbours(liveCell, "+","+","-");
        assertTrue(liveCell.nextGeneration().isAlive());
    }

    @Test
    public void shouldDieInTheNextGenerationIfThereAreMoreThanThreeLiveNeighbours() {
        Cell liveCell = new Cell("+");

        addNeighbours(liveCell, "+","+","+","+","-");
        assertFalse(liveCell.nextGeneration().isAlive());
    }

    @Test
    public void shouldComeToLifeInTheNextGenerationIfThereAreThreeLiveNeighbours() {
        Cell deadCell = new Cell("-");
        assertFalse(deadCell.nextGeneration().isAlive());

        addNeighbours(deadCell, "+","+","+");
        assertTrue(deadCell.nextGeneration().isAlive());
    }

    @Test
    public void shouldNotComeToLifeInTheNextGenerationIfThereAreTwoLiveNeighbours() {
        Cell deadCell = new Cell("-");
        assertFalse(deadCell.nextGeneration().isAlive());

        addNeighbours(deadCell, "+","+");
        assertFalse(deadCell.nextGeneration().isAlive());
    }

    @Test
    public void shouldNotComeToLifeInTheNextGenerationIfThereAreFourLiveNeighbours() {
        Cell deadCell = new Cell("-");
        assertFalse(deadCell.nextGeneration().isAlive());

        addNeighbours(deadCell, "+","+","+","+");
        assertFalse(deadCell.nextGeneration().isAlive());
    }

    @Test
    public void shouldNotDieInTheNextGenerationIfThereAreThreeLiveNeighbours() {
        Cell liveCell = new Cell("+");

        addNeighbours(liveCell, "+","+","+","-");
        assertTrue(liveCell.nextGeneration().isAlive());
    }

    private void addNeighbours(Cell cell, String... statuses) {
        for (String status : statuses) {
            cell.knowYourNeighbour(new Cell(status));
        }
    }

}
