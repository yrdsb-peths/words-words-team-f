public class Queue<Item> 
{
    private Node first, last;

    private class Node
    {
        Item item;
        Node next;
    }

    //returns whether queue is empty based on first pointer
    public boolean isEmpty()
    {
        return first == null;
    }

    public void enqueue(Item item)
    {
        //store old last into variable oldLast
        Node oldLast = last;

        //create new node and place last in queue
        last = new Node();
        last.item = item;
        last.next = null;

        //if queue is empty, set first pointer to new node (now first node)
        if(isEmpty())
        {
            first = last;
        }
        //if queue is not empty, set previous last node to point to newest node
        else
        {
            oldLast.next = last;
        }
    }

    public Item dequeue()
    {
        Item item = first.item;
        first = first.next;
        if(isEmpty())
        {

            last = null;
        }

        return item;
    }
    
    public Item peek()
    {
        if (isEmpty())
        {
            return null;  // Return null if queue is empty
        }
        return first.item;  // Return the first item without removing it
    }
    
    
}