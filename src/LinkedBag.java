public class LinkedBag<T> implements BagInterface<T>
{
    private Node firstNode;     // head reference of the chain of nodes
    private int numOfEntries;

    public LinkedBag()
    {
        firstNode = null;
        numOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry)
    {
        // Add to beginning of chain
        Node newNode = new Node(newEntry);
        //newNode.next = firstNode;         // Make new node reference rest of chain (first Node is null if chain is empty
        newNode.setNextNode(firstNode);     // Make new node reference rest of chain (first Node is null if chain is empty
        firstNode = newNode;                // New node is at beginning of chain
        numOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if(firstNode != null)
        {
            result = firstNode.getData();
            firstNode = firstNode.next;
            numOfEntries--;
        }
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if(nodeN != null)
        {
            nodeN.data = firstNode.data;

            firstNode = firstNode.next;
            numOfEntries--;
            result = true;
        }
        return result;
    }

    @Override
    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }else{
                currentNode = currentNode.getNextNode();
            }
        }
        return found;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numOfEntries];

        int i = 0;
        Node currentNode = firstNode;
        while((i<numOfEntries) && (currentNode != null))
        {
            result[i] = currentNode.data;
            i++;
            currentNode = currentNode.next;
        }
        return result;
    }

    @Override
    public void clear() {
        while(!isEmpty())
        {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;
        while((loopCounter < numOfEntries) && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

    private class Node
    {
        private T data;     // Entry in bag
        private Node next;  // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion,null);
        }

        private Node(T dataPortion, Node nextNode)
        {
            data = dataPortion;
            next = nextNode;
        }

        private T getData()
        {
            return data;
        }

        private void setData(T newData)
        {
            data = newData;
        }

        private Node getNextNode()
        {
            return next;
        }

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        }
    }

    private Node getReferenceTo(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null))
        {
            if(anEntry.equals(currentNode.data))
            {
                found = true;
            }else{
                currentNode = currentNode.getNextNode();
            }
        }
        return currentNode;
    }
}
