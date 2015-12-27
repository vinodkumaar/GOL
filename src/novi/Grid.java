package novi;

public class Grid {
    private Cell[][] cells;
    private final String WHITE_SPACE = " ";
    private final String NEW_LINE = "\n";

    public Grid(String inputPattern) {
        String[] rows = inputPattern.split("\n");
        String[] columns = rows[0].split(" ");
        cells = new Cell[rows.length][columns.length];
        for (int row = 0; row < rows.length; row++) {
            columns = rows[row].split(" ");
            for (int column = 0; column < columns.length; column++) {
                cells[row][column] = new Cell(columns[column]);
            }
        }
    }

    public String display() {
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                builder.append(cells[row][column].display());
                if (column + 1 != cells[column].length)
                    builder.append(WHITE_SPACE);
            }
            if (row + 1 != cells.length)
                builder.append(NEW_LINE);
        }
        return builder.toString();
    }

    public Grid nextGeneration() {
        knowTheNeighbours();
        moveToNextGeneration();
        return this;
    }

    private void knowTheNeighbours() {
        for (int row = 0; row < cells.length; row++) {
            int noOfColumns = cells[row].length;
            for (int column = 0; column < noOfColumns; column++) {
                int previousRow = row - 1;
                int nextRow = row + 1;
                if (previousRow >= 0) {
                    knowTheNeighboursIn(previousRow, column, noOfColumns, cells[row][column]);
                }
                if (nextRow < cells.length) {
                    knowTheNeighboursIn(nextRow, column, noOfColumns, cells[row][column]);
                }
                knowTheNeighboursIn(row, column, noOfColumns, cells[row][column]);
            }
        }
    }

    private void knowTheNeighboursIn(int rowPointer, int columnPointer, int noOfColumns, Cell currentCell) {
        if (currentCell != cells[rowPointer][columnPointer]) {
            currentCell.knowYourNeighbour(cells[rowPointer][columnPointer]);
        }
        if (columnPointer + 1 < noOfColumns) {
            currentCell.knowYourNeighbour(cells[rowPointer][columnPointer + 1]);
        }
        if (columnPointer - 1 >= 0) {
            currentCell.knowYourNeighbour(cells[rowPointer][columnPointer - 1]);
        }
    }

    private void moveToNextGeneration() {
        Cell[][] nextGenerationCells = new Cell[cells.length][cells[0].length];
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                nextGenerationCells[row][column] = cells[row][column].nextGeneration();
            }
        }
        cells = nextGenerationCells;
    }
}
