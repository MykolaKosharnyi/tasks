package collections;

import java.util.*;

/**
 * Implementation of CustomTreeSet.
 *
 * @version 1.0
 * @author Mykola Kosharny
 */
@SuppressWarnings("rawtypes")
public class CustomTreeSet<T extends Comparable> implements Set<T>, NavigableSet<T> {

    // Collection variables
    private Node<T> rootNode = new Node<>();
    private int collectionSize = 0;

    /**
     * Main Node element for creation of CustomTreeSet collection structure
     * @param <T> type of Objects to contain.
     */
    @SuppressWarnings("hiding")
	private class Node<T>{
        // Variables
        Node<T> parentNode;
        Node<T> leftNode;
        Node<T> rightNode;
        T dataObject;

        public Node() {
        }

        public Node(T dataObject) {
            this.dataObject = dataObject;
        }

        @SuppressWarnings("unused")
		public Node(Node<T> parentNode, Node<T> leftNode, Node<T> rightNode, T dataObject) {
            this.parentNode = parentNode;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.dataObject = dataObject;
        }

        @SuppressWarnings("unused")
		public Node<T> getParentNode() {
            return parentNode;
        }

        @SuppressWarnings("unused")
		public void setParentNode(Node<T> parentNode) {
            this.parentNode = parentNode;
        }

        @SuppressWarnings("unused")
		public Node<T> getLeftNode() {
            return leftNode;
        }

        @SuppressWarnings("unused")
		public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        @SuppressWarnings("unused")
		public Node<T> getRightNode() {
            return rightNode;
        }

        @SuppressWarnings("unused")
		public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }

        @SuppressWarnings("unused")
		public T getDataObject() {
            return dataObject;
        }

        @SuppressWarnings("unused")
		public void setDataObject(T dataObject) {
            this.dataObject = dataObject;
        }
    }

    // Implemented methods

    /**
     * Method adds a new Object to collection and returns an operation result.
     *
     * @param newDataObject Object to add
     * @return boolean result of operation
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean add(T newDataObject) {
        Objects.requireNonNull(newDataObject, "CustomTreeSet class: add(): method parameter shouldn't be 'null'!");
        if (rootNode.dataObject == null){
            rootNode.dataObject = newDataObject;
            collectionSize++;
        } else {
            Node<T> currentNode = rootNode;
            //while (current != null) {
            while (true) {
                int compareResult = newDataObject.compareTo(currentNode.dataObject);
                if (compareResult == 0) {
                    return false;
                } else if (compareResult < 0) {
                    if (currentNode.leftNode != null) {
                        currentNode = currentNode.leftNode;
                    } else {
                        currentNode.leftNode = new Node<>(newDataObject);
                        currentNode.leftNode.parentNode = currentNode;
                        collectionSize++;
                        return true;
                    }
                } else {
                    if (currentNode.rightNode != null) {
                        currentNode = currentNode.rightNode;
                    } else {
                        currentNode.rightNode = new Node<>(newDataObject);
                        currentNode.rightNode.parentNode = currentNode;
                        collectionSize++;
                        return true;
                    }
                }
            }
        }
        return true;
    }


    /**
     * Method removes passed as parameter object from the collection
     * and returns an operation result.
     *
     * @param dataObject Object to remove
     * @return operation result
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean remove(Object dataObject) {
        Objects.requireNonNull(dataObject, "CustomTreeSet class: remove(): method parameter shouldn't be 'null'!");
        T removedObject = (T) dataObject;
        //System.out.println("remove() -> rootNode.data: " + rootNode.dataObject);
        if (collectionSize == 0){
            return false;
        }
        Node<T> currentNode = rootNode;
        while (currentNode != null) {
            int compareResult = currentNode.dataObject.compareTo(removedObject);
            if (compareResult == 0) {
                collectionSize--;
                if (currentNode.leftNode == null && currentNode.rightNode == null) {
                    if (currentNode.parentNode.leftNode == currentNode) {
                        currentNode.parentNode.leftNode = null;
                    } else {
                        currentNode.parentNode.rightNode = null;
                    }
                } else if (currentNode.leftNode != null) {
                    Node<T> maxLeftNode = currentNode.leftNode;
                    while (maxLeftNode.rightNode != null) {
                        maxLeftNode = maxLeftNode.rightNode;
                    }
                    currentNode.dataObject = maxLeftNode.dataObject;
                    if (maxLeftNode.parentNode.rightNode == maxLeftNode) {
                        if (maxLeftNode.leftNode != null) {
                            maxLeftNode.parentNode.rightNode = maxLeftNode.leftNode;
                        } else {
                            maxLeftNode.parentNode.rightNode = null;
                        }
                    } else {
                        maxLeftNode.parentNode.leftNode = maxLeftNode.leftNode;
                    }
                } else {
                    Node<T> maxRight = currentNode.rightNode;
                    while (maxRight.leftNode != null) {
                        maxRight = maxRight.leftNode;
                    }
                    currentNode.dataObject = maxRight.dataObject;
                    if (maxRight.parentNode.leftNode == maxRight) {
                        if (maxRight.rightNode != null) {
                            maxRight.parentNode.leftNode = maxRight.rightNode;
                        } else {
                            maxRight.parentNode.leftNode = null;
                        }
                    } else {
                        maxRight.parentNode.rightNode = maxRight.rightNode;
                    }
                }
                return true;
            } else if (compareResult < 0) {
                currentNode = currentNode.rightNode;
            } else { // compareResult > 0
                currentNode = currentNode.leftNode;
            }
        }
        return false;
    }


    /**
     * Method returns size of the collection.
     *
     * @return number of containing objects
     */
    @Override
    public int size() {
        return collectionSize;
    }

    /**
     * Method returns boolean value if the collection is Empty.
     *
     * @return boolean operation result
     */
    @Override
    public boolean isEmpty() {
        return collectionSize == 0;
    }

    /**
     * Method checks if the collection contains passed as a parameter
     * Object and returns a checking result.
     *
     * @param dataObject Object to check
     * @return boolean operation result
     */
    @SuppressWarnings("unchecked")
	@Override
    public boolean contains(Object dataObject) {
        Objects.requireNonNull(dataObject, "CustomTreeSet class: contains(): method parameter shouldn't be 'null'!");
        if (collectionSize == 0){ return false; }
        T searchObject = (T) dataObject;
        Node<T> currentNode = rootNode;
        while (currentNode != null) {
            int compareResult = searchObject.compareTo(currentNode.dataObject);
            if (compareResult == 0) {
                return true;
            } else if (compareResult < 0) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
        return false;
    }

    // Unimplemented methods 

    @Override
    public T lower(T t) {
        return null;
    }

    @Override
    public T floor(T t) {
        return null;
    }

    @Override
    public T ceiling(T t) {
        return null;
    }

    @Override
    public T higher(T t) {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public NavigableSet<T> descendingSet() {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }

    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        return null;
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
