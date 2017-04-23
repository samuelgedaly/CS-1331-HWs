//Collaborated with Benjamin Vaisberg
import java.util.Collection;

/**
* Class SignlyLinkedList implements the LinkedList interface
* @param <E> generic
* @author Samuel Gedaly
* @version 1.0
*/
public class SinglyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

/**
* Creates the SinglyLinkedList object
*/
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    /**
     * Returns the element in the linked list at the specified index.
     * Does not change the contents of the list in any way. If the given
     * index is negative or greater than the maximum possible index, returns
     * null.
     *
     * @param index of element to be retrieved
     * @return the element at the given index or null if index out of bounds
     */
    @Override
    public E get(int index) {
        if (isEmpty() || index < 0) {
            return null;
        } else if (index >= size) {
            return null;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.element;
        }
    }

    /**
     * Adds the specified piece of data to the end of the linked list.
     * This method should execute in O(1) (constant) time. This means that
     * you should not iterate over the whole list to add the item to the end
     * (we will check for this).
     *
     * @param data the object to be added to the linked list
     */
    @Override
    public void add(E data) {
        Node<E> temp = new Node<>(data);
        if (isEmpty()) {
            head = temp;
            tail = temp;
            size++;
        } else {
            tail.next = temp;
            tail = temp;
            size++;
        }
    }

    /**
     * Adds given piece of data to the linked list at the given index.
     * All items that were originally at the index or after the index should
     * be shifted down by one. If the index specified is not valid, returns
     * false. Otherwise, returns true.
     *
     * If the index specified is 0 or if it is one larger than the maximum
     * current index (ie if index is equal to the size of the linked list),
     * then this method should execute in O(1) (constant) time. This means that
     * you should not iterate over the entire list to add the element, as it
     * is unnecessary to do so.
     *
     * @param index the index at which to add the item
     * @param data the item to be added to te linked list
     * @return true if the data could be added at the given index
     */
    @Override
    public boolean add(int index, E data) {
        Node<E> temp = new Node<>(data);
        if (index == size && !isEmpty()) {
            tail.next = temp;
            tail = temp;
            size++;
            return true;
        } else if (index == 0 && isEmpty()) {
            head = temp;
            tail = temp;
            size++;
            return true;
        } else if (index > size || index < 0) {
            return false;
        } else if (index == 0) {
            temp.next = head;
            head = temp;
            size++;
            return true;
        } else {
            Node<E> temp2 = head;
            for (int i = 0; i < index - 1; i++) {
                temp2 = temp2.next;
            }
            temp.next = temp2.next;
            temp2.next = temp;
            size++;
            return true;
        }
    }

     /**
     * Adds each element in the Collection to the end of the linked list.
     *
     * @param c the collection of items to add to the end of the linked list
     */
    @Override
    public void addAll(Collection<? extends E> c) {
        for (E elem : c) {
            add(elem);
            size++;
        }
    }

    /**
     * Determines whether or not the given piece of data is in the linked list.
     *
     * @param data the item to check
     * @return true if the linked list contains the item, false otherwise
     */
    @Override
    public boolean contains(E data) {
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (get(i) == data) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Determines whether or not every element of the given Collection is
     * in the linked list.
     *
     * @param c the Collection of elements to check
     * @return true if list contains every element in the Collection
     */
    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for (E elem : c) {
            if (!contains((E) c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds the first element of the list equal to the given piece of data
     * and removes it from the list. Returns false if the given piece of data
     * is not in the list and therefore cannot be removed.
     *
     * @param data the piece of data to be removed from the list
     * @return true if the item was removed, false if list does not contain it
     */
    @Override
    public boolean remove(E data) {
        if (isEmpty()) {
            return false;
        } else {
            Node<E> current = head;
            if (current.element == data) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                    return true;
                } else {
                    head = head.next;
                    size--;
                    return true;
                }
            } else {
                for (int i = 0; i < size - 1; i++) {
                    if ((current.next).element == data) {
                        if (i == size - 2) {
                            tail = current;
                            tail.next = null;
                            size--;
                            return true;
                        } else {
                            current.next = (current.next).next;
                            size--;
                            return true;
                        }
                    }
                    current = current.next;
                }
                return false;
            }
        }
    }

    /**
     * Removes and returns the item in the list at the given index.
     * All items at indices after the given index are shifted down by one.
     *
     * @param index the index of the item to remove from the linked list
     * @return the removed item
     */
    @Override
    public E remove(int index) {
        if (isEmpty()) {
            return null;
        } else if (index >= size) {
            return null;
        } else {
            E elem = get(index);
            boolean rem = remove(elem);
            if (rem) {
                return elem;
            }
            return null;
        }

    }

    /**
     * Removes all elements in the given collection from the linked list.
     *
     * @param c the Collection of items to remove
     * @return true if all elements in the Collection were removed.
     */
    @Override
    public boolean removeAll(Collection<? extends E> c) {
        boolean tf;
        for (E elem : c) {
            tf = remove(elem);
            if (!tf) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of elements in the linked list. This method
     * should execute in O(1) (constant) time. This means that you should not
     * iterate over the entire list to count the number of items, but rather
     * you should maintain a size variable that you can just return here.
     *
     * @return the number of elements in the linked list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if the linked list has no elements.
     *
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all elements from the list. After calling this method,
     * the isEmpty method should return true.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


}

/**
* Inner class Node
* @author Samuel Gedaly
* @version 1.0
*/
class Node<E> {
    E element; 
    Node<E> next;
    public Node(E e) {
        element = e;
    }
}