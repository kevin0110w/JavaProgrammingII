
/**
 * 8|1|6
 * -----
 * 3|5|7
 * ------
 * 4|9|2
 */
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);
        int counter = 1;
        int row = 0;
        int column = size / 2;
        int curr_row = 0;
        int curr_col = 0;
        while (counter <= size * size) {
            square.placeValue(column, row, counter);
            counter++;
            curr_row = row;
            curr_col = column;
            row -= 1;
            column += 1;
            if (row == -1) {
                row = size - 1;
            }
            if (column == size) {
                column = 0;
            }

            if (square.readValue(column, row) != 0) {
                row = curr_row + 1;
                column = curr_col;
                if (row == -1) {
                    row = size - 1;
                }
            }
        }
        return square;
    }
}
