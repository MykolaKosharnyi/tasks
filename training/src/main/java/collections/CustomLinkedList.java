package collections;

import java.util.*;

/**
 * Implementation of LinkedList.
 *
 * @version 1.0
 * @author Mykola Kosharny
 */
public class CustomLinkedList<T> implements List<T> {

    // Variables
    int size = 0;
    int modifications;

    Node<T> firstNode = null;
    Node<T> lastNode = null;

    // Node class for creating double link chains
    @SuppressWarnings("hiding")
	private class Node<T> {
        private Node<T> prevNode;
        private Node<T> nextNode;
        private T dataObject;

        @SuppressWarnings("unused")
		public Node(){}

        public Node(Node<T> prevNode, Node<T> nextNode, T dataObject) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.dataObject = dataObject;
        }
    }

    /**
     * Method adds new element to the collection.
     * @param newElement new element
     * @return result of operation
     */
    @Override
    public boolean add(T newElement) {

        if (firstNode == null) {
            lastNode = firstNode = new Node<T>(null, null, newElement);
        } else {
            Node<T> oldLast = lastNode;
            lastNode = new Node<>(oldLast, null, newElement);
            oldLast.nextNode = lastNode;
        }
        size++;
        modifications++;
        return true;
    }

    /**
     * Method adds new element to the collection in specified position.
     * @param index index of position
     * @param element new element
     */
    @Override
    public void add(int index, T element) {
        checkIndex(index);
        if(index == 0){
            addFirst(element);
        } else if(index == size - 1){
            addLast(element);
        } else {
            Node<T> nextNode = getNodeByIndex(index);
            Node<T> newNode = new Node<>(nextNode.prevNode, nextNode, element);
            newNode.prevNode = newNode;
            modifications++;
        }
    }

    /**
     * Method adds new element to head of a collection chain.
     * @param newElement new element
     */
    public void addFirst(T newElement){
        if (firstNode == null) {
            add(newElement);
        } else {
            Node<T> tempFirst = firstNode;
            firstNode = new Node<>(null, tempFirst, newElement);
            tempFirst.prevNode = firstNode;
            modifications++;
        }
    }

    /**
     * Method adds new element to tail of collection chain.
     * @param newElement
     */
    public void addLast(T newElement){
        add(newElement);
    }

    /**
     * Method gets an element of specified position order.
     * @param index index of element
     * @return element
     */
    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) getNodeByIndex(index).dataObject;
    }

    /**
     * Method check range of asked indexes. Internal method.
     * @param index index
     */
    private void checkIndex(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("checkIndex(): Index value is not correct.");
        }
    }

    /**
     * Method returns a Node by specified index value.
     * @param index index of Node
     * @return Node<T>
     */
    private Node<T> getNodeByIndex(int index) {
        Node<T> tempNode;
        if( index <= (size >> 1)){
            tempNode = firstNode;
            for(int i = 0; i < index; i++){
                tempNode = tempNode.nextNode;
            }
        } else {
            tempNode = lastNode;
            for(int i = size - 1; i > index; i--){
                tempNode = tempNode.prevNode;
            }
        }
        /*tempNode = firstNode;                         // Straight find - brute alternate
        for(int i = 0; i < index; i++){
            tempNode = tempNode.nextNode;
        }*/
        return tempNode;
    }

    /**
     * Method gets a first element of the collection.
     * @return element
     */
    public T getFirst(){
        if(firstNode == null) {
            throw new NoSuchElementException("There is no such element.");
        }
        return (T) firstNode.dataObject;
    }

    /**
     * Method returns last element of the collection.
     * @return element
     */
    public T getLast(){
        if(lastNode == null) {
            throw new NoSuchElementException("There is no such element.");
        }
        return (T) lastNode.dataObject;

    }

    /**
     * Method returns size of the collection.
     * @return int size.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method checks if the collection is empty
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method removes an element from collection by value.
     * @param o element to remove
     * @return result of remove
     */
    @Override
    public boolean remove(Object o) {
        Node<T> tempNode = firstNode;
        if(o == null){
            for(int i = 0; i < size; i++){
                if( tempNode.dataObject == null){
                    removeNode(tempNode);
                    return true;
                }
                tempNode = tempNode.nextNode;
            }
            return true;
        } else {
            for(int i = 0; i < size; i++){
                if(tempNode.dataObject.equals(o)){
                    removeNode(tempNode);
                    return true;
                }
                tempNode = tempNode.nextNode;
            }
        }
        return false;
    }

    /**
     * Internal method removes Node from collection's chain.
     * @param node Node
     */
    private void removeNode(Node<T> node) {
        if(isEmpty()){
            throw new NoSuchElementException("The Node cannot be removed.");
        } else if(size == 1){
            firstNode = null;
            lastNode = null;
        } else {
            Node<T> prev = node.prevNode;
            Node<T> next = node.nextNode;
            if(prev != null) {
                prev.nextNode = next;
            } else {
                firstNode = next;
            }
            if(next != null) {
                next.prevNode = prev;
            } else {
                lastNode = prev;
            }
        }
        size--;
        modifications++;
    }

    /**
     * Mehod removes element from collection by index.
     * @param index index of element to remove
     * @return removed element
     */
    @Override
    public T remove(int index) {
        checkIndex(index);
        Node<T> resultNode = getNodeByIndex(index);
        T dataObject = (T) resultNode.dataObject;
        removeNode(resultNode);
        return dataObject;
    }

    /**
     * Method removes first element from collection.
     * @return removed element
     */
    public T removeFirst(){
        T result;
        if(firstNode == null){
            throw new NoSuchElementException("There is no such element.");
        }
        result = (T) firstNode.dataObject;
        if(firstNode == lastNode){
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
            firstNode.prevNode = null;
        }
        size--;
        modifications++;
        return result;
    }

    /**
     * Method removes last element from collection.
     * @return removed element
     */
    public T removeLast(){
        if(lastNode == null){
            throw new NoSuchElementException("There is no such element.");
        }
        T result = (T) lastNode.dataObject;
        lastNode.prevNode.nextNode = null;
        size--;
        modifications++;
        return result;
    }

    /**
     * Method modify specified by index element.
     * @param index of element to modify
     * @param element new value of element
     * @return old element value
     */
    @Override
    public T set(int index, T element) {
        checkIndex(index);
        Node<T> currentNode = getNodeByIndex(index);
        T dataObject = (T) currentNode.dataObject;
        currentNode.dataObject = element;
        modifications++;
        return dataObject;
    }

    /**
     * Method clears the collection.
     */
    @Override
    public void clear() {
        firstNode = lastNode = null;
        size = 0;
        modifications++;
    }

    /**
     * Method returns an iterator for the collection.
     * @return Iterator object
     */
    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    /**
     * Method returns ListIterator<T> object.
     * @return ListIterator<T>
     */
    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>(){

            // List iterator variables
            int iteratorModifications = modifications;
            int currentPointer = 0;
            Node<T> currentNode = getNodeByIndex(currentPointer);
            Node<T> lastReturned;

            /**
             * Method checks if there is a next element from current iterator position.
             * @return boolean value
             */
            @Override
            public boolean hasNext() {
                //return (currentNode != null && currentNode.nextNode != null);
                return (currentNode != null);
            }

            /**
             * Method returns next element from current iterator position.
             * @return next element
             */
            @Override
            public T next() {
                checkModifications();
                if (!hasNext()) {
                    throw new NoSuchElementException("There is no such element.");
                }
                lastReturned = currentNode;
                currentNode = currentNode.nextNode;
                currentPointer++;
                return (T) lastReturned.dataObject;
            }

            /**
             * Method check is there any previous element from current iterator position.
             * @return boolean value
             */
            @Override
            public boolean hasPrevious() {
                return (currentNode != null && currentNode.prevNode != null);
            }

            /**
             * Method returns previous element from current iterator position.
             * @return previous element of collection
             */
            @Override
            public T previous() {
                lastReturned = currentNode;
                currentNode = currentNode.prevNode;
                currentPointer--;
                return lastReturned.dataObject;
            }

            /**
             * Method returns an index of next element.
             * @return next element index
             */
            @Override
            public int nextIndex() {
                return currentPointer++;
            }

            /**
             * Method returns previous element index.
             * @return previous element index
             */
            @Override
            public int previousIndex() {
                return currentPointer--;
            }

            /**
             * Method removes an element in the current iterator position.
             */
            @Override
            public void remove() {
                checkModifications();
                //iteratorModifications++;
                if (lastReturned == null) {
                    throw new IndexOutOfBoundsException("Recently returned object is null");
                }
                if (lastReturned == firstNode) {
                    CustomLinkedList.this.removeFirst();
                } else if (lastReturned == lastNode) {
                    CustomLinkedList.this.removeLast();
                } else {
                    lastReturned.nextNode.prevNode = lastReturned.prevNode;
                    lastReturned.prevNode.nextNode = lastReturned.nextNode;
                    lastReturned = null;
                    modifications++;
                    iteratorModifications++;
                }
            }

            /**
             * Internal method checks concurrent modification attempts.
             */
            private void checkModifications() {
                if (iteratorModifications != CustomLinkedList.this.modifications) {
                    throw new ConcurrentModificationException("Concurrent modifications is not supported.");
                }
            }

            /**
             * Method modify en element in the current ierator position.
             * @param t new element
             */
            @Override
            public void set(T t) {
                checkModifications();
                iteratorModifications++;
                lastReturned.dataObject = t;
            }

            /**
             * Method adds new element in the current position.
             * @param t element to add.
             */
            @Override
            public void add(T t) {
                checkModifications();
                modifications++;
                if (lastReturned == firstNode) {
                    CustomLinkedList.this.addFirst(t);
                } else if (lastReturned == lastNode) {
                    CustomLinkedList.this.add(t);
                } else {
                    Node<T> node = new Node<>(null, null, t);
                    lastReturned.nextNode.prevNode = node;
                    node.nextNode = lastReturned.nextNode;
                    lastReturned.nextNode = node;
                    node.prevNode = lastReturned;
                }
            }
        };
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("This operation is not supported.");
    }
}
