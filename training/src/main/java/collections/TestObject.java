package collections;

/**
 * @version 1.0
 * @author Mykola Kosharny
 */
public class TestObject {
	// Variables
    private String name;
    private int value;

    // Constructor
    public TestObject(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestObject)) return false;

        TestObject that = (TestObject) o;

        if (value != that.value) return false;
        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value;
        return result;
    }

	@Override
	public String toString() {
		return "TestObject [name=" + name + ", value=" + value + "]";
	}
}
