public interface BagInterface<T>
{
    public int getCurrentSize();

    public boolean isEmpty();

    /**
     * Adds a new entry to this bag
     * @param newEntry  The object to be added as a new entry
     * @return True
     */
    public boolean add(T newEntry);

    /**
     * Removes one unspecified entry from this bag, if possible
     * @return  Either the removed object, if the removal was successful
     */
    public T remove();

    /**
     * Removes one occurence of a given entry from this bag, if possible
     * @param anEntry: The entry to be removed
     * @return True if the removal was successful, or false otherwise
     */
    public boolean remove(T anEntry);

    public boolean contains(T anEntry);

    public T[] toArray();

    public void clear();

    /**
     * Count the number of times a given entry appears in a bag
     * @param anEntry: The entry to be counted
     * @return The # of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry);
}
