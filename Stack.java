public class Stack
{
    //pointer to first node
    private Node first;

    /**
     * Class of nodes
     */
    private class Node
    {
        private String item;
        private Node next;
    }

    /**
     * Returns whether or not the first node is empty
     * @return 
     */
    private boolean isEmpty()
    {
        return first == null;
    }

    /**
     * insert new node to front of stack
     * @param item
     */
    public void push (String item)
    {        
        //bump first node down to second
        Node second = first;

        //create new node with new item
        first = new Node();
        first.item = item;

        //set new node to point to old first (now second node)
        first.next = second;
    }
    
    /**
     * Remove first object (object from top of stack)
     * 
     * @return object previously stored in first node
     */
    public String pop()
    {
        String item = first.item;
        first = first.next;
        return item;
    }

    /**
     * return falue stored in first pointer
     * @return
     */
    public String peek()
    {
        return first.item;
    }
}          