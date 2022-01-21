/**
 * @author saraphthasasikumar (251093788)
 * @param <T> generic type used to create linked list
 *  Represents the implementation of a doubly linked list
 */
public class DoubleList<T> {

    //declare instance variables
    private DoubleNode<T> head;
    private DoubleNode<T> rear;
    private int numDataItems;

    /**
     * constructor that initializes the instance variables
     */
    public DoubleList() {

        head = null;
        rear = null;
        numDataItems = 0;

    }

    /**
     * Method that adds data to the list at a given index
     * @param index position at which node will be added
     * @param newData data that the node will contain
     * @throws InvalidPositionException thrown if the index value is out of bounds/Invalid
     */
    public void addData(int index, T newData) throws InvalidPositionException {

        if (index < 0 || index > numDataItems) {
            throw new InvalidPositionException("Invalid Index Position");
        }

        //create new node containing value in newData
        DoubleNode<T> newNode = new DoubleNode<T>(newData);

        //if head has no value then the head and rear is set to value of newNode
        if (head == null) {

            head = newNode;
            rear = newNode;

        // if the index is the first position then the current head is set as the next node and the new node is set
        //as the previous node and then the new  node is set as the new head
        } else if (index == 0) {

            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        //if the index is the last value then the rear node is set as the previous node to the new node
        //the node after rear is set to newNode and rear is set to newNode
        } else if (index == numDataItems) {

            newNode.setPrev(rear);
            rear.setNext(newNode);
            rear = newNode;

        } else {
            //temporary reference node created
            DoubleNode<T> tempNode = head;

            //loops through list until index reached
            for (int i = 1; i < index; i++) {
                tempNode = tempNode.getNext();
            }

            //sets the new node at given index
            newNode.setNext(tempNode.getNext());
            tempNode.setNext(newNode);
            newNode.setPrev(tempNode);
            newNode.getNext().setPrev(newNode);


        }
        //increase the value of numDataItems by one after node is added
        numDataItems++;

    }

    /**
     * Returns a node at a given index
     * @param index the position at which the node is
     * @return a node at the given index
     * @throws InvalidPositionException thrown if index is invalid/out of bounds
     */
    public DoubleNode<T> getNode(int index) throws InvalidPositionException {

        //create node object
        DoubleNode<T> nodeToReturn = new DoubleNode<T>();

        if (index < 0 || index > numDataItems) {
            throw new InvalidPositionException("Invalid Index Position");
        }

        if (index == 0) {
            nodeToReturn = head;
        } else if (index == numDataItems - 1) {
            nodeToReturn = rear;
        } else {
            nodeToReturn = head;

            for (int i = 0; i < index; i++) {
                nodeToReturn = nodeToReturn.getNext();
            }
        }

        return nodeToReturn;
    }

    /**
     * Removes data at the given index
     * @param index position at which node will be removed
     * @throws InvalidPositionException thrown if index is invalid/out of bounds
     */
    public void removeData(int index) throws InvalidPositionException {

        //create new doubleNode object
        DoubleNode<T> nodeToDelete = new DoubleNode<T>();

        if (index < 0 || index > numDataItems||numDataItems==0) {
            throw new InvalidPositionException("Invalid Index Position");
        }

        //if only one node in list then head and rear set to null
        if (numDataItems == 1) {
            head = null;
            rear = null;
        } else {

            nodeToDelete = head;

            //loop through list until index at which node to delete is found and let nodeToDelete = that value
            for (int i = 0; i < index; i++) {
                nodeToDelete = nodeToDelete.getNext();
            }

            if (nodeToDelete == head) {

                head = nodeToDelete.getNext();
                nodeToDelete.getNext().setPrev(null);
                nodeToDelete.setNext(null);

            } else if (nodeToDelete == rear) {

                rear = nodeToDelete.getPrev();
                nodeToDelete.getPrev().setNext(null);
                nodeToDelete.setPrev(null);

            } else {

                nodeToDelete.getPrev().setNext(nodeToDelete.getNext());
                nodeToDelete.getNext().setPrev(nodeToDelete.getPrev());
                nodeToDelete.setNext(null);
                nodeToDelete.setPrev(null);
            }

        }
        //decreases the num of items by one
        numDataItems--;

    }

    /**
     * gets the data stored within a node at given index
     * @param index position at which node is in list
     * @return the data stored in node at index position
     * @throws InvalidPositionException thrown if index is invalid/ out of bounds
     */
    public T getData(int index) throws InvalidPositionException {


        DoubleNode<T> node = new DoubleNode<T>();
        T dataItem = null;

        if (index < 0 || index > numDataItems) {
            throw new InvalidPositionException("invalid");
        }


        if (index == 0 ){
            node = head;
            dataItem = node.getData();
        }
        else if (index == numDataItems -1){
            node = rear;
            dataItem = node.getData();
        }
        else{
            node = head;
            for (int i = 0; i< index; i++){
                node = node.getNext();
            }
            dataItem = node.getData();
        }

        return dataItem;
    }

    /**
     * sets the data within a node at given index
     * @param index positon at which node is in
     * @param newData data to be stored in node
     * @throws InvalidPositionException thrown if index is out of bounds
     */
    public void setData(int index, T newData) throws InvalidPositionException{

        DoubleNode<T> node = new DoubleNode<T>();
        T dataItem = null;

        if (index < 0 || index > numDataItems) {
            throw new InvalidPositionException("Invalid Index Position");

        }

        if (index == 0){
            node = head;
            node.setData(newData);
        }
        else if (index == numDataItems -1){
            node = rear;
            node.setData(newData);
        }
        else{
            node = head;
            for (int i = 0; i< index; i++){
                node = node.getNext();
            }
            node.setData(newData);
        }

    }

}







