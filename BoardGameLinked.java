/**
 * @author saraphthasasikumar (251093788)
 * Create the board using a doubly linked list structure from values provided in a text file
 */
public class BoardGameLinked {

    //declare instance variables
    int boardLength;
    int boardWidth;
    SnakeLinked theSnake;
    DoubleList<String>[] board;

    /**
     * Constructor that initializes instance variables using values read from a text file
     * @param boardFile name of the text file that contains values to initialize variables
     */
    public BoardGameLinked (String boardFile){

        String fileName = boardFile;

        //create and initialize MyFileReader Object to use methods from MyFileReader to raad boardFile
        MyFileReader in;
        in = new MyFileReader(fileName);

        //read and assign values from boardFile to variables
        in.readInt();
        in.readInt();

        boardLength = in.readInt();
        boardWidth = in.readInt();


        int Value5 = in.readInt();
        int Value6 = in.readInt();

        //new snake object created containing the 5th and 6th values of the boardFile
        theSnake = new SnakeLinked (Value5, Value6);

        //new array for the board is created and size is initialized by given board width
        board = new DoubleList[boardWidth];

        //set all elements of board to empty
        for (int i = 0; i< boardWidth; i++) {
            board[i] = new DoubleList<String>();
            for (int j = 0; j < boardLength; j++) {
                board[i].addData(j, "empty");
            }

        }


        //entire files is read and position and object stored in the double linked array
        while (in.endOfFile()==false) {
            int row = in.readInt();
            int col = in.readInt();
            String string1=  in.readString();
            board[row].addData(col, string1);
        }



    }

    /**
     * Returns the object contained in given row and col
     * @param row row that object is in
     * @param col column that object is in
     * @return the object stored in the position found in given row and col
     * @throws InvalidPositionException thrown if the row or col is out of bounds
     */
    public String getObject(int row, int col) throws InvalidPositionException{

        if (row >= boardWidth || row < 0 || col >= boardLength || col<0){
            throw new InvalidPositionException("Invalid Parameters");
        }
        return board[row].getData(col);
    }

    /**
     * sets an object at given row and column
     * @param row row where object will be stored
     * @param col column where object will be store
     * @param newObject object that will be stored at row and col
     */
    public void setObject (int row, int col, String newObject){

        if (row >= boardWidth || row < 0 || col >= boardLength || col<0){
            throw new InvalidPositionException("Invalid Parameters");
        }

        board[row].setData(col, newObject );
    }

    /**
     * returns the snake object
     * @return snake object is returned
     */
    public SnakeLinked getSnakeLinked(){

        return theSnake;
    }

    /**
     * stores the value of newSnake in instance variable theSnake
     * @param newSnake value of the new snake
     */
    public void setSnakeLinked(SnakeLinked newSnake){
        theSnake = newSnake;

    }

    /**
     *
     * @return the board length
     */
    public int getLength(){
        return boardLength;
    }

    /**
     *
     * @return the board width
     */
    public int getWidth(){
        return boardWidth;
    }

}



