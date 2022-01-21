/**
 * @author saraphthasasikumar (251093788)
 * @param <T> generic typr used to create linked list
 *  Defines an interface to a Doubly linked list
 */
public class DoubleNode<T> {

//Declare instance variables
    private DoubleNode<T> next;
    private DoubleNode<T> prev;
    private T data;

    /**
     * constructor that initializes the instance variables
     */
    public DoubleNode(){
        next = null;
        prev = null;
        data = null;
    }

    /**
     * method creates new double node containing newData
     * @param newData value that data is set to
     */
    public DoubleNode (T newData){
        data = newData;
        prev = null;
        next = null;
    }

    /**
     *
     * @return returns the next node in the doubly linked list
     */
    public DoubleNode<T> getNext (){
        return next;
    }

    /**
     *
     * @return the previous node in doubly linked list
     */
    public DoubleNode<T> getPrev (){
        return prev;
    }

    /**
     *
     * @return data stored in the node referenced
     */
    public T getData (){
        return data;
    }

    /**
     *
     * @param nextNode set as the next node
     */
    public void setNext (DoubleNode<T> nextNode){
        next = nextNode;
    }

    /**
     *
     * @param prevNode set as the previous node
     */
    public void setPrev (DoubleNode<T> prevNode){
        prev = prevNode;
    }

    /**
     *
     * @param newData set as new data at node referenced
     */
    public void setData (T newData){
        data = newData;
    }








}
