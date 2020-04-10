import java.io.PrintStream;
import java.util.NoSuchElementException;

/**
 * IntegerQueueImpl class
 */
public class IntegerQueueImpl implements IntegerQueue {
    private Node first = null;
    private Node last = null;
    private int size = 0;

    /**
     * Empty Constructor
     */
    public IntegerQueueImpl(){
    }

    /**
     * @return true if the queue is empty,false if the queue has elements
     */
    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    /**
     * insert a Integer item to the queue (end of the queue)
     */
    @Override
    public void put(Integer item){
        Node node = new Node(item);
        if (isEmpty()){
            first = node;
            last = node;
        }
        else{
            last.setNext(node);
            last = node;
        }
        this.size++;
    }

    /**
     * remove and @return the oldest item of the queue
     * @return oldest item of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public Integer get() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Integer item = first.getItem();
        if (first == last){
            first = last = null;
        }
        else {
            first = first.next;
        }
        this.size--;
        return item;
    }

    /**
     * return without removing the oldest item of the queue
     * @return oldest item of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public Integer peek() throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (first.getItem());
    }

    /**
     * print the elements of the queue, starting from the oldest
     * item, to the print stream given as argument. For example, to
     * print the elements to the
     * standard output, pass System.out as parameter. E.g.,
     * printQueue(System.out);
     */
    @Override
    public void printQueue(PrintStream stream){
        Node node = first;
        StringBuilder stringBuilder = new StringBuilder();

        if(isEmpty()){
            stringBuilder.append("Queue is empty");
            stream.println(stringBuilder);
            stream.flush();
        }
        else{
            // while not at end of list, output current node's data
            stringBuilder.append(" FIRST -> ");

            while (node != null) {
                stringBuilder.append(node.getItem());

                if (node.getNext() != null)
                    stringBuilder.append(" -> ");

                node = node.next;
            }
            stringBuilder.append(" <- LAST");
            stream.println(stringBuilder);
            stream.flush();
        }
    }

    /**
     *
     * @return a StringBuilder without using stream
     */
    public StringBuilder printQueue(){
        Node node = first;
        StringBuilder stringBuilder = new StringBuilder();

        if(isEmpty()){
            stringBuilder.append("Queue is empty");
        }
        else{
            // while not at end of list, output current node's data
            stringBuilder.append(" FIRST -> ");

            while (node != null) {
                stringBuilder.append(node.getItem());

                if (node.getNext() != null)
                    stringBuilder.append(" -> ");

                node = node.next;
            }
            stringBuilder.append(" <- LAST");
        }
        return  stringBuilder;
    }

    /**
     * @return the size of the queue, 0 if it is empty
     */
    @Override
    public int size(){
        return this.size;
    }
}
