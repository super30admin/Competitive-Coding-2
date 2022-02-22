/*
    
    Time Complexity : O(2^n);
    Space Complexity : O(n)
    
*/
public class Main
{
	public static void main(String[] args) {
		int[] weights = new int[]{10, 20, 30};
		int[] value = new int[]{60, 100, 120};
		
		System.out.println(knapsack(weights, value, 0, 50));
	}
	
	public static int knapsack(int[] weights, int[] value, int i, int cap){
	    if(i==weights.length){
	        return 0;
	    }
	    
	    if(cap==0){
	        return 0;
	    }
	    
	    int yes = value[i] + knapsack(weights, value, i + 1, cap - weights[i]);
	    int no = knapsack(weights, value, i + 1, cap);
	    
	    if(cap >= weights[i]){
	        return Math.max(yes, no);
	    }else{
	        return no;
	    }
	}
}

