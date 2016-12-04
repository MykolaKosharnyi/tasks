package collections;

import java.util.*;

/**
 * Implementation of ArrayList.
 *
 * @version 1.0
 * @author Mykola Kosharny
 */
public class CustomArrayList<E> implements List<E> {

	    // Variables
	    /**
	     * Default initial capacity.
	     */
	    private static final int DEFAULT_CAPACITY = 16;
	    /**
	     * The count of right shift positions in the process of new capacity calculating.
	     */
	    private static final int CAPACITY_SHIFT_MULTIPLIER = 1;
	    /**
	     * Shared empty array instance used for empty instances.
	     */
	    private static final Object[] EMPTY_ELEMENTDATA = {};

	    /**
	     * The array buffer into which the elements of the CustomArrayList are stored.
	     * The capacity of the ArrayList is the length of this array buffer. Any
	     * empty ArrayList with elementData == EMPTY_ELEMENTDATA
	     * will be expanded to DEFAULT_CAPACITY when the first element is added.
	     */
	    private Object[] customListData;

	    /**
	     * The size of the ArrayList (the number of elements it contains).
	     *
	     */
	    private int size = 0;

	    /**
	     * The count of modification operations with data. For list iteration purposes.
	     */
	    private int modificationsCount = 0;

	    // Constructors
	    /**
	     * Constructs an empty list with the specified initial capacity.
	     *
	     * @param  initialCapacity  the initial capacity of the list
	     * @throws IllegalArgumentException if the specified initial capacity
	     *         is negative
	     */
	    public CustomArrayList(int initialCapacity) {
	        if (initialCapacity > 0) {
	            this.customListData = new Object[initialCapacity];
	        } else if (initialCapacity == 0) {
	            this.customListData = EMPTY_ELEMENTDATA;
	        } else {
	            throw new IllegalArgumentException("Illegal Capacity: " +
	                    initialCapacity);
	        }
	    }

	    /**
	     * Constructs an empty list with an initial capacity of zero.
	     */
	    public CustomArrayList() {
	        this.customListData = EMPTY_ELEMENTDATA;
	    }

	    // Methods
	    /**
	     * Returns the number of elements in this list.  If this list contains
	     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
	     * <tt>Integer.MAX_VALUE</tt>.
	     *
	     * @return the number of elements in this list
	     */
	    @Override
	    public int size() {
	        return size;
	    }

	    /**
	     * Returns <tt>true</tt> if this list contains no elements.
	     *
	     * @return <tt>true</tt> if this list contains no elements
	     */
	    @Override
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    @Override
	    public boolean contains(Object o) {
	        throw new UnsupportedOperationException("Operation 'contains' is not supported.");
	    }

	    /**
	     * Iterator for CustomArrayList collection
	     * @return iterator for for CustomArrayList collection
	     */
	    @Override
	    public Iterator<E> iterator() {
	        return listIterator();
	    }

	    @Override
	    public Object[] toArray() {
	        throw new UnsupportedOperationException("Operation 'toArray' is not supported.");
	    }

	    @Override
	    public <T> T[] toArray(T[] a) {
	        throw new UnsupportedOperationException("Operation 'toArray' is not supported.");
	    }

	    /**
	     * The method add new E object to collection
	     * @param element to add
	     * @return boolean result of operation
	     */
	    @Override
	    public boolean add(E element) {
	        ensureCapacity(size + 1);
	        customListData[size++] = element;
	        modificationsCount++;
	        return true;
	    }

	    /**
	     * The method add new E object to collection position index
	     * @param index int position in the collection
	     * @param element E object to add
	     */
	    @Override
	    public void add(int index, E element) {
	        rangeCheck(index);
	        ensureCapacity(size + 1);
	        System.arraycopy(customListData, index, customListData, index + 1,
	                size - index);
	        customListData[index] = element;
	        size++;
	        modificationsCount++;
	    }

	    /**
	     * The method checks available space for int elements in the collection.
	     * @param i number of elements.
	     */
	    private void ensureCapacity(int i) {
	        if(i > customListData.length){
	            increaseCapacity();
	        }
	    }

	    /**
	     * Method increases capacity of internal data array.
	     */
	    private void increaseCapacity() {
	        if (customListData.length == 0){
	            customListData = new Object[DEFAULT_CAPACITY];
	        } else {
	            int oldCapacity = customListData.length;
	            int newCapacity = oldCapacity + (oldCapacity >> CAPACITY_SHIFT_MULTIPLIER);
	            Object[] newCustomListData = new Object[newCapacity];
	            System.arraycopy(customListData, 0, newCustomListData, 0, oldCapacity);
	            customListData = newCustomListData;
	        }
	    }

	    /**
	     * Method checks index value for add operation in specific position.
	     * @param index position in data array.
	     */
	    private void rangeCheck(int index) {
	        if (index > size || index < 0)
	            throw new IndexOutOfBoundsException("Incorrect index range for Add() method.");
	    }

	    /**
	     * Method removes passed object from the collection.
	     * @param o object to remove
	     * @return boolean result of operation
	     */
	    @Override
	    public boolean remove(Object o) {
	        if (o == null) {
	            for (int i = 0; i < size; i++)
	                if (customListData[i] == null) {
	                    removeByIndex(i);
	                    return true;
	                }
	        } else {
	            for (int i = 0; i < size; i++)
	                if (o.equals(customListData[i])) {
	                    removeByIndex(i);
	                    return true;
	                }
	        }
	        return false;
	    }

	    /**
	     * Method removes object by passed index.
	     * @param i index of element to remove.
	     */
	    private void removeByIndex(int i) {
	        int numMoved = size - i - 1;
	        if (numMoved > 0)
	            System.arraycopy(customListData, i + 1, customListData, i,
	                    numMoved);
	        customListData[--size] = null;
	        modificationsCount++;
	    }


	    @Override
	    public boolean containsAll(Collection<?> c) {
	        throw new UnsupportedOperationException("Operation 'containsAll' is not supported.");
	    }

	    @Override
	    public boolean addAll(Collection<? extends E> c) {
	        throw new UnsupportedOperationException("Operation 'addAll' is not supported.");
	    }

	    @Override
	    public boolean addAll(int index, Collection<? extends E> c) {
	        throw new UnsupportedOperationException("Operation 'addAll' is not supported.");
	    }

	    @Override
	    public boolean removeAll(Collection<?> c) {
	        throw new UnsupportedOperationException("Operation 'removeAll' is not supported.");
	    }

	    @Override
	    public boolean retainAll(Collection<?> c) {
	        throw new UnsupportedOperationException("Operation 'retainAll' is not supported.");
	    }

	    /**
	     * Method clears the collection from all elements.
	     */
	    @Override
	    public void clear() {
	        customListData = EMPTY_ELEMENTDATA;
	        size = 0;
	        modificationsCount++;
	    }


	    /**
	     * Method returns Element of the collection by index.
	     * @param index of element to return
	     * @return element
	     */
	    @SuppressWarnings("unchecked")
		@Override
	    public E get(int index) {
	        rangeCheck(index);
	        return (E) customListData[index];
	    }

	    /**
	     * Method modify element of collection by passed index with acquired element.
	     * @param index of element to modify.
	     * @param element - new value.
	     * @return old value of element.
	     */
	    @SuppressWarnings("unchecked")
		@Override
	    public E set(int index, E element) {
	        rangeCheck(index);
	        E oldValue = (E)customListData[index];
	        customListData[index] = element;
	        modificationsCount++;
	        return oldValue;
	    }

	    /**
	     * Method removes element of the collection by index.
	     * @param index of element to remove
	     * @return removed element
	     */
	    @SuppressWarnings("unchecked")
		@Override
	    public E remove(int index) {
	        rangeCheck(index);
	        E oldValue = (E)customListData[index];
	        removeByIndex(index);
	        return oldValue;
	    }

	    @Override
	    public int indexOf(Object o) {
	        throw new UnsupportedOperationException("Operation 'indexOf' is not supported.");
	    }

	    @Override
	    public int lastIndexOf(Object o) {
	        throw new UnsupportedOperationException("Operation 'lastIndexOf' is not supported.");
	    }

	    /**
	     * Method returns ListIterator<E> object for the collection.
	     * @return ListIterator
	     */
	    @Override
	    public ListIterator<E> listIterator() {
	        return new ListIterator<E>() {
	            int pointer = 0;
	            int modificationsCount = CustomArrayList.this.modificationsCount;

	            /**
	             * Method checks available objects on the way of increasing of iteration index.
	             * @return boolean result of check.
	             */
	            @Override
	            public boolean hasNext() {
	                checkModifications();
	                return pointer < size;
	            }

	            /**
	             * Method return next Element of the collection.
	             * @return next Element
	             */
	            @SuppressWarnings("unchecked")
				@Override
	            public E next() {
	                E nextElement = null;
	                checkModifications();
	                try {
	                    rangeCheck(pointer + 1);
	                    nextElement = (E)customListData[pointer++];
	                } catch (IndexOutOfBoundsException ex){
	                    throw new NoSuchElementException(ex.getMessage());
	                }
	                return nextElement;
	            }

	            /**
	             * Method checks for available element on the back way of collection iteration.
	             * @return boolean result of check.
	             */
	            @Override
	            public boolean hasPrevious() {
	                checkModifications();
	                return pointer > 0;
	            }

	            /**
	             * Method returns previous elements of the collection.
	             * @return
	             */
	            @SuppressWarnings("unchecked")
				@Override
	            public E previous() {
	                E prevElement = null;
	                checkModifications();
	                try {
	                    rangeCheck(pointer - 1);
	                    prevElement = (E)customListData[--pointer];
	                } catch (IndexOutOfBoundsException ex){
	                    throw new NoSuchElementException(ex.getMessage());
	                }
	                return prevElement;
	            }

	            /**
	             * Method returns next iteration index of a Element or -1 in the case of bounds overflow.
	             * @return index of next Element
	             */
	            @Override
	            public int nextIndex() {
	                checkModifications();
	                int nextInd = pointer + 1;
	                if(nextInd > 0 && nextInd < size){
	                    return nextInd;
	                } else return -1;
	            }

	            /**
	             * Method returns previous iteration index of a Element or -1 in the case of bounds overflow.
	             * @return index of next Element
	             */
	            @Override
	            public int previousIndex() {
	                checkModifications();
	                int prevInd = pointer - 1;
	                if(prevInd > 0 && prevInd < size){
	                    return prevInd;
	                } else return -1;
	            }

	            /**
	             * Method removes Element from the collection on current iteration pointer value.
	             */
	            @Override
	            public void remove() {
	                checkModifications();
	                try{
	                    rangeCheck(pointer);
	                    CustomArrayList.this.removeByIndex(pointer);
	                    if(pointer == CustomArrayList.this.size()){
	                        pointer--;
	                    }
	                    modificationsCount++;
	                } catch (ArrayIndexOutOfBoundsException ex){
	                    throw new NoSuchElementException(ex.getMessage());
	                }
	            }

	            /**
	             * Method modifies current Element by another one.
	             * @param element to modify with.
	             */
	            @Override
	            public void set(E element) {
	                checkModifications();
	                CustomArrayList.this.set(pointer, element);
	                modificationsCount++;
	            }

	            /**
	             * Method adds new Element in the current position
	             * @param element
	             */
	            @Override
	            public void add(E element) {
	                checkModifications();
	                CustomArrayList.this.add(pointer, element);
	                modificationsCount++;
	            }

	            /**
	             * Method allows to avoid of external collection modifications.
	             * @throws ConcurrentModificationException in case of external collection modifications.
	             */
	            private void checkModifications() {
	                if (modificationsCount != CustomArrayList.this.modificationsCount) {
	                    throw new ConcurrentModificationException("Concurrent access is not supported for List Iteration.");
	                }
	            }
	        };
	    }

	    @Override
	    public ListIterator<E> listIterator(int index) {
	        throw new UnsupportedOperationException("The operation 'listIterator(index)' is not supported.");
	    }

	    @Override
	    public List<E> subList(int fromIndex, int toIndex) {
	        throw new UnsupportedOperationException("Operation 'sublist' is not supported.");
	    }

	    /**
	     * Service method for capacity checking in Tests.
	     * @return collection capacity.
	     */
	    public int capacity(){
	        return customListData.length;
	    }
	}
