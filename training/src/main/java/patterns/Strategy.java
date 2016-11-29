package patterns;

import java.util.Arrays;

public class Strategy {
	public static void main(String[] args) {
		StrategyClient c = new StrategyClient();
		
		int[] arr0 = {1,3,2,1};
		c.setStrategy(new BubbleSort());
		c.executeStrategy(arr0);
		
		System.out.println();
		
		int[] arr1 = {11, 4, 2, 7, 8, 54};
		c.setStrategy(new InsertingSort());
		c.executeStrategy(arr1);
	}
}
//Context
class StrategyClient{
	Sorting strategy;
	public void setStrategy(Sorting strategy){
		this.strategy=strategy;
	}
	public void executeStrategy(int[] arr){
		strategy.sort(arr);
	}
}

//Strategy
interface Sorting{
	void sort(int[] arr);
}

//Bubble sorting strategy
class BubbleSort implements Sorting{
	public void sort(int[] arr){
		System.out.println("Bubble sorting");
		System.out.println("Before:\t" + Arrays.toString(arr));
		for(int barier=arr.length-1;barier>=0;barier--){
			for(int i=0; i<barier;i++){
				if(arr[i]>arr[i+1]){
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					
				}
			}
		}
		System.out.println("After:\t"+Arrays.toString(arr));
	}
}

//Inserting sorting strategy
class InsertingSort implements Sorting{
	public void sort(int[] arr){
		System.out.println("Inserting sorting");
		System.out.println("Before:\t" + Arrays.toString(arr));
		for(int barier = 1; barier < arr.length; barier++){
			int index=barier;
			while(index-1>=0 && arr[index]<arr[index-1]){
				int tmp = arr[index];
				arr[index] = arr[index-1];
				arr[index-1] = tmp;
				index--;
			}
		}
		System.out.println("After:\t"+Arrays.toString(arr));
	}
}