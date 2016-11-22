package patterns;

public class IteratorApp {

	public static void main(String[] args) {
		ConcreteAggregator c = new ConcreteAggregator();
		
		Iterator iterator = c.getIterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}

interface Iterator{
	boolean hasNext();
	Object next();
}

interface Aggregator{
	Iterator getIterator();
}

class ConcreteAggregator implements Aggregator{
	String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

	@Override
	public Iterator getIterator() {
		return new TaskIterator();
	}
	
	private class TaskIterator implements Iterator{

		int index = 0;
		
		@Override
		public boolean hasNext() {
			if( index < tasks.length ){
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			return tasks[index++];
		}
		
	}
}