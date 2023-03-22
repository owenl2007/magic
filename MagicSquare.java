public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */

    public static int calculateCheckSum(int[][] array2d)
    {
        int sumOfFirstRow = 0;
        for (int val : array2d[0]) sumOfFirstRow += val;
        return sumOfFirstRow;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */

    public static boolean magicRows(int[][] array2d, int checkSum)
    {

        int rowSum;
        for (int row = 0; row < array2d.length; row++) {
            rowSum = 0;
            for (int col = 0; col < array2d[row].length; col++) {
                rowSum += array2d[row][col];
            }
            if (rowSum != checkSum) return false;
        }

        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum)
    {
        int rowCol;
        for (int col = 0; col < array2d[0].length; col++) {
            rowCol = 0;
            for (int row = 0; row < array2d.length; row++) {
                rowCol += array2d[row][col];
            }
            if (rowCol != checkSum) return false;
        }
        return true;

    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum)
    {
        int row = 0, col = 0, tempSum = 0;
        while (row < array2d.length) {
            tempSum += array2d[row][col];
            row++;
            col++;
        }
        if (tempSum != checkSum) return false;
        row = 0;
        col = array2d[row].length-1;
        tempSum = 0;
        while (row < array2d.length) {
            tempSum += array2d[row][col];
            row++;
            col--;
        }
        if (tempSum != checkSum) return false;
        return true;

    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d)
    {
        int squareVal = calculateCheckSum(array2d);
        if (magicRows(array2d, squareVal) && magicColumns(array2d, squareVal) && magicDiagonals(array2d, squareVal))

            return true;

        else return false;

    }

}