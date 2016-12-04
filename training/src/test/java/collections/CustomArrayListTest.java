package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ListIterator;

/**
 * Unit tests for CustomArrayList application.
 * Methods names corresponding with same names in CustomArrayList class.
 *
 * @version 1.0
 * @author Mykola Kosharny
 *
 */
public class CustomArrayListTest {

    private CustomArrayList<TestObject> customArrayList;

    @Before
    public void initTest(){
        customArrayList = new CustomArrayList<>();
    }

    @Test
    public void constructorsTest(){
        // Testing capacity changes
        CustomArrayList<TestObject> customArrayList1 = new CustomArrayList<>();
        Assert.assertEquals("On creation, without elements",customArrayList1.capacity(), 0);
        
        CustomArrayList<TestObject> customArrayList2 = new CustomArrayList<>(5);
        Assert.assertEquals("Initialization with 5 elements", customArrayList2.capacity(), 5);
        
        customArrayList1.add(new TestObject("Test#1", 111));
        Assert.assertEquals("Check if initialized capacity changed", customArrayList1.capacity(), 16);
    }

    @Test
    public void addGetTest(){
        TestObject addedObject = new TestObject("Test#2", 222);
        customArrayList.add(addedObject);
        TestObject returnedObject = customArrayList.get(0);
        Assert.assertEquals(addedObject, returnedObject);
    }

    @Test
    public void setTest(){
        TestObject addedObject = new TestObject("Test#3", 333);
        customArrayList.add(addedObject);
        
        TestObject setObject = new TestObject("Test#4", 444);
        customArrayList.set(0, setObject);
        TestObject returnedObject = customArrayList.get(0);
        
        Assert.assertEquals("check name",returnedObject.getName(), setObject.getName());
        Assert.assertEquals("check value",returnedObject.getValue(), setObject.getValue());
        Assert.assertEquals("check refferensis",returnedObject, setObject);
    }

    @Test
    public void removeTest(){
        TestObject addedObject1 = new TestObject("Test#5", 555);
        TestObject addedObject2 = new TestObject("Test#6", 666);
        customArrayList.add(addedObject1);
        customArrayList.add(addedObject2);
        TestObject returnedObject1 = customArrayList.remove(0);
        boolean removeResult = customArrayList.remove(addedObject2);
        
        Assert.assertEquals("deleting by index", addedObject1, returnedObject1);
        Assert.assertEquals("deleting by object", removeResult, true);
        Assert.assertEquals("check if really object was deleted", customArrayList.size(), 0);
    }

    @Test
    public void clearTest(){
        TestObject addedObject;
        for(int i = 0; i < 1000; i++) {
            addedObject = new TestObject("Test#" + i, 100 + i);
            customArrayList.add(addedObject);
        }
        Assert.assertEquals("Before clear", customArrayList.size(), 1000);
        customArrayList.clear();
        Assert.assertEquals("After clear", customArrayList.size(), 0);
    }

    @Test
    public void listIteratorTest(){
        final int ITERATIONS = 1000;
        TestObject addedObject;
        for(int i = 0; i < ITERATIONS; i++) {
            addedObject = new TestObject("Test#" + i, ITERATIONS + i);
            customArrayList.add(addedObject);
        }
        ListIterator<TestObject> listIterator = customArrayList.listIterator();
        Assert.assertTrue("check on hasNext()", listIterator.hasNext());

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
                iterCount--;
            }
        }
        Assert.assertEquals(iterCount, 0);
    }
}
