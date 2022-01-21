/**
 * @author saraphthasasikumar (251093788)
 * Stored information about the snake in a doubly linked list as snake moves
 */

public class SnakeLinked {

    //declare instance variables
    int snakeLength;
    DoubleList<Position> snakeBody;

    /**
     * constructor initializing the instance variables
     * @param row variable representing row at which snake head is
     * @param col variable representing row at which snake head is
     */
    public SnakeLinked(int row, int col){

        snakeLength = 1;
        snakeBody = new DoubleList<Position>();
        Position head = new Position(row, col);
        snakeBody.addData(0, head);



    }

    /**
     *
     * @return value of snakeLength
     */
    public int getLength(){
        return snakeLength;
    }

    /**
     *
     * @param index position at which node is
     * @return the Position object stored in the node of the doubly linked list with the given index.
     */
    public Position getPosition(int index){

        //if index is out of bounds then null is returned
        if (index<0 ||index>=snakeLength){
            return null;
        }

        else{

            return snakeBody.getData(index);

        }


    }

    /**
     *
     * @param pos position object containing values of row and column
     * @return returns true if pos is in the doubly linked list of snakeBody, and it returns false otherwise.
     */
    public boolean snakePosition(Position pos){

        boolean inSnake = false;
        //loops through every element in list and compares to see if pos in list of snakeBody
        for (int i = 0; i<snakeLength; i++){
            if (snakeBody.getData(i).equals(pos)){
                inSnake = true;
            }

        }
        return inSnake;
    }

    /**
     *
     * @param direction variable representing the direction snake will move in
     * @return returns the new position that the head of the snake would occupy if the snake moved in the direction
     * specified by the parameter
     */
    public Position newHeadPosition (String direction){

        //new position object storing data stored the head of snake
        Position head = snakeBody.getData(0);
        //new position object created copying the row and col value of the head
        Position newHead = new Position (head.getRow(), head.getCol());

        // if up then value of row decreased by one
        if (direction.equals("up")){

            newHead.setRow(newHead.getRow()-1);

        }
        // if up then value of row increased by one
        else if (direction.equals("down")){
            newHead.setRow(newHead.getRow()+1);

        }
        // if right then value of col increased by one
        else if (direction.equals("right")){
            newHead.setCol(newHead.getCol()+1);

        }
        // if left then value of col decreased by one
        else if (direction.equals("left")){
            newHead.setCol(newHead.getCol()-1);

        }

        return newHead;
    }

    /**
     *  moves the snake in the specified direction
     * @param direction variable representing the direction snake will move towards
     */
    public void moveSnakeLinked (String direction){

            //loops through list and shifts data of nodes over by one position
            for (int i = 0; i < snakeLength - 1; i++) {
                Position node = snakeBody.getData(i);
                snakeBody.setData(i + 1, node);
            }

        //sets the new value for the snake head
        snakeBody.setData(0, newHeadPosition(direction));


    }

    /**
     * decreases the value of snakeLength by 1 and deletes the last node in the doubly
     * linked list of snakeBody
     */
    public void shrink(){

        snakeLength = snakeLength -1;
        snakeBody.removeData(snakeLength);
    }

    /**
     *increases the length of the snake by 1 and moves the snake’s head in the
     * direction specified.
     * @param direction variable representing the direction snake will move towards
     */
    public void grow(String direction){

        snakeLength = snakeLength +1;

        Position node = snakeBody.getData(snakeLength-2);
        snakeBody.addData(snakeLength-1,node);

        for (int i = 0; i < snakeLength - 1; i++) {
            snakeBody.setData(i + 1, snakeBody.getData(i));
        }

        snakeBody.setData(0, newHeadPosition(direction));







    }


}
