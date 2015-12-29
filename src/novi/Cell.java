package novi;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private boolean alive;
    private List<Cell> liveNeighbours = new ArrayList<Cell>();

    public Cell(String alive) {
        this.alive = alive.equals("+") && !alive.equals("-");
    }

    private Cell(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public String display() {
        return alive? "+":"-";
    }

    public void knowYourNeighbour(Cell neighbour) {
        if (neighbour.isAlive())
            liveNeighbours.add(neighbour);
    }

    public Cell nextGeneration() {
        if (alive) {
            return new Cell(liveNeighbours.size() > 1 && liveNeighbours.size() < 4);
        } else {
            return new Cell(liveNeighbours.size() == 3);
        }
    }
}
