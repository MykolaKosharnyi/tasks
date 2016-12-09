package collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.stream.IntStream;

/**
 * Unit tests for CustomTreeSet application.
 * Methods names corresponding with same names in CustomTreeSet class.
 *
 * @version 1.0
 * @author Mykola Kosharny
 *
 */
public class CustomTreeSetTest {

    // Constants
    public static final int ITERATIONS = 1000;

    // Variables
    private CustomTreeSet<Integer> customTreeSet;

    // Tests
    @Before
    public void initTest(){
        customTreeSet = new CustomTreeSet<>();
    }

    @Test
    public void addTest(){
        IntStream.range(0, ITERATIONS)
                .mapToObj(Integer::new)
                .forEach(x -> customTreeSet.add(x));
        Assert.assertEquals(customTreeSet.size(), ITERATIONS);

        IntStream.range(0, ITERATIONS / 2)
                .mapToObj(Integer::new)
                .forEach(x -> customTreeSet.add(x));
        Assert.assertEquals(customTreeSet.size(), ITERATIONS);
    }

    @Test(expected = NullPointerException.class)
    public void addExceptionTest(){
        customTreeSet.add(null);
    }

    @Test
    public void removeTest(){
        int start = 21;
        int step = 2;
        int iterationDivider = 3;

        // simple deletion test
        IntStream.range(0, ITERATIONS).boxed().forEach(x -> customTreeSet.add(x));
        IntStream.iterate(start, x -> x + step).limit(ITERATIONS / iterationDivider).boxed().forEach(x -> customTreeSet.remove(x));
        Assert.assertEquals(customTreeSet.size(), ITERATIONS - ITERATIONS / iterationDivider);

        // repeatable deletion test
        IntStream.iterate(start, x -> x + step).limit(ITERATIONS / iterationDivider).boxed().forEach(x -> customTreeSet.remove(x));
        Assert.assertEquals(customTreeSet.size(), ITERATIONS - ITERATIONS / iterationDivider);

    }

    @Test(expected = NullPointerException.class)
    public void removeExceptionTest(){

        IntStream.range(0, ITERATIONS)
                .boxed()
                .forEach(x -> customTreeSet.add(x));
        customTreeSet.remove(null);
    }

    @Test
    public void removeTest2(){
        customTreeSet.add(5);
        customTreeSet.add(10);
        customTreeSet.add(12);
        customTreeSet.remove(5);
        customTreeSet.remove(10);
        customTreeSet.remove(12);
        Assert.assertFalse(customTreeSet.contains(5));
        Assert.assertFalse(customTreeSet.contains(10));
        Assert.assertFalse(customTreeSet.contains(12));
    }

    @Test
    public void sizeTest(){
        int localIterateCorrection = 28;
        int start = 35;
        int step = 3;

        IntStream.iterate(start, x -> x - step)
                .limit(ITERATIONS - localIterateCorrection)
                .boxed()
                .forEach(x -> customTreeSet.add(x));
        Assert.assertEquals(customTreeSet.size(), ITERATIONS - localIterateCorrection);
    }

    @Test
    public void containsTest(){
        int start = 139;
        int step = 2;

        IntStream.iterate(start, x -> x + step)
                .limit(ITERATIONS)
                .boxed()
                .forEach(x -> customTreeSet.add(x));

        Assert.assertTrue(customTreeSet.contains(new Integer(141)));
        Assert.assertTrue(customTreeSet.contains(new Integer(143)));
        Assert.assertTrue(customTreeSet.contains(new Integer(147)));
        Assert.assertTrue(customTreeSet.contains(new Integer(141)));
        Assert.assertTrue(customTreeSet.contains(new Integer(161)));

        Assert.assertFalse(customTreeSet.contains(new Integer(111)));
        Assert.assertFalse(customTreeSet.contains(new Integer(123)));
        Assert.assertFalse(customTreeSet.contains(new Integer(140)));
        Assert.assertFalse(customTreeSet.contains(new Integer(137)));
        Assert.assertFalse(customTreeSet.contains(new Integer(160)));
    }
}
