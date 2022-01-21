/**
 * @author : Saraphtha Sasikumar (251093788)
 * Defines the position object for the snakeBody
 */
public class Position {

    //declare instance variables
    private int positionRow;
    private int positionColumn;

    //constructor

    /**
     *
     * @param row intializes position row
     * @param col initializes position col
     */
    public Position (int row, int col) {
        positionRow = row;
        positionColumn = col;

    }
    //returns row value

    /**
     *
     * @return the value of position row
     */
    public int getRow() {

        return positionRow;
    }
    //returns col value

    /**
     *
     * @return returns the value of position row
     */
    public int getCol() {

        return positionColumn;
    }
    //sets a new value for psotionRow

    /**
     *
     * @param newRow the new value set to positionRow
     */
    public void setRow(int newRow) {

        positionRow = newRow;
    }
    //sets a new value for positionCol

    /**
     *
     * @param newCol the new value set to positionCol
     */
    public void setCol(int newCol) {

        positionColumn = newCol;
    }
    //checks if the row and col of one object is equal to another position object

    /**
     *
     * @param otherPosition posiiton object that the original position object will be compared to
     * @return returns (true/false) boolean depending on whether or not both position objects match
     */
    public boolean equals (Position otherPosition) {
        if (this.positionRow == otherPosition.positionRow && this.positionColumn == otherPosition.positionColumn)
        {
            return true;
        }

        else
        {
            return false;
        }
    }


}
