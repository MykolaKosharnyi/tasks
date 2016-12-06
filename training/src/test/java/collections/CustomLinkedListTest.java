package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ListIterator;

/**
 * Unit tests for CustomLinkedList application.
 * Methods names corresponding with same names in CustomLinkedList class.
 *
 * @version 1.0
 * @author Mykola Kosharny
 *
 */
public class CustomLinkedListTest {

    private CustomLinkedList<TestObject> customLinkedList;

    @Before
    public void initTest(){
        customLinkedList = new CustomLinkedList<>();
    }

    @Test
    public void addGetTest(){
        TestObject addedObject = new TestObject("Test#234", 234);
        customLinkedList.add(addedObject);
        TestObject returnedObject = customLinkedList.get(0);
        Assert.assertEquals("Check just adding and getting object",addedObject, returnedObject);

        addedObject = new TestObject("Test#456", 456);
        customLinkedList.addFirst(addedObject);
        returnedObject = customLinkedList.getFirst();
        Assert.assertEquals("Add first and get fritst object", addedObject, returnedObject);

        addedObject = new TestObject("Test#567", 567);
        customLinkedList.addLast(addedObject);
        returnedObject = customLinkedList.getLast();
        Assert.assertEquals("Add last, get Last to equals", addedObject, returnedObject);
    }

    @Test
    public void setTest(){
        TestObject addedObject = new TestObject("Test#3", 333);
        customLinkedList.add(addedObject);
        TestObject setObject = new TestObject("Test#4", 444);
        customLinkedList.set(0, setObject);
        TestObject returnedObject = customLinkedList.get(0);
        Assert.assertEquals("set in position, check by name of object",returnedObject.getName(), setObject.getName());
        Assert.assertEquals("set in position, check by value", returnedObject.getValue(), setObject.getValue());
        Assert.assertEquals("check objects",returnedObject, setObject);
    }

    @Test
    public void removeTest(){
        TestObject addedObject1 = new TestObject("Test#5", 555);
        TestObject addedObject2 = new TestObject("Test#6", 666);
        customLinkedList.add(addedObject1);
        customLinkedList.add(addedObject2);
        TestObject returnedObject1 = customLinkedList.remove(0);
        boolean removeResult = customLinkedList.remove(addedObject2);
        Assert.assertEquals("removing element in 0 position", addedObject1, returnedObject1);
        Assert.assertTrue("check if remove object", removeResult);
        Assert.assertEquals("after deleting size must be 0",customLinkedList.size(), 0);
    }

    @Test
    public void clearTest(){
        TestObject addedObject;
        for(int i = 0; i < 1000; i++) {
            addedObject = new TestObject("Test#" + i, 100 + i);
            customLinkedList.add(addedObject);
        }
        Assert.assertEquals("before clearing",customLinkedList.size(), 1000);
        customLinkedList.clear();
        Assert.assertEquals("after clearing", customLinkedList.size(), 0);
    }

    @Test
    public void listIteratorTest(){
        final int ITERATIONS = 1000;
        TestObject addedObject;
        for(int i = 0; i < ITERATIONS; i++) {
            addedObject = new TestObject("Test#" + i, ITERATIONS + i);
            customLinkedList.add(addedObject);
        }
        ListIterator<TestObject> listIterator = customLinkedList.listIterator();
        Assert.assertTrue(listIterator.hasNext());

        // Iterations counting test
        int iterCount = 0;
        for(int i = 0; i < ITERATIONS; i++) {
            Assert.assertEquals(listIterator.next().getValue(), ITERATIONS + i);
            iterCount++;
        }
        Assert.assertEquals(iterCount, ITERATIONS);

        // Back iterations test
        for(int i = ITERATIONS - 1; i >= 0; i--) {
            if(listIterator.hasPrevious()) {
                Assert.assertEquals(listIterator.previous().getValue(), ITERATIONS + i);
            }
            iterCount--;
        }
        Assert.assertEquals(iterCount, 0);
    }
    @Test
    public void listIteratorRemoveTest(){
        final int ITERATIONS = 30;
        TestObject addedObject;
        for(int i = 0; i < ITERATIONS; i++) {
            addedObject = new TestObject("Test#" + i, i);
            customLinkedList.add(addedObject);
        }
        ListIterator<TestObject> listIterator = customLinkedList.listIterator();
        Assert.assertTrue(listIterator.hasNext());
        for(int i = 0; i < ITERATIONS / 2; i++){
            listIterator.next();
        }
        listIterator.remove();
        TestObject middleInstance = listIterator.next();
        Assert.assertEquals(middleInstance.getValue(), 15);

    }
}
