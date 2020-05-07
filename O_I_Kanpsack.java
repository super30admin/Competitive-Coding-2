package Solution;

import java.util.HashMap;

public class O_I_Kanpsack {
	static HashMap<String, Integer> map;
	static int sum;
	private static int knapSack(int cap, int[]wt, int[]val, int n){
		map = new HashMap<>();
		sum = 0;
		int r = helper(cap , wt, val,0,sum);
		return r;
	}
	private static int helper(int cap, int[]wt, int[]val,int i , int sum){
		
		String key = ""+cap+""+i;
		if(map.containsKey(key))
			return map.get(key);
		
		if(cap < 0)
			return 0;
		
		if(cap == 0 || i==val.length)
			return sum;
		
		int case1 = helper(cap - wt[i], wt, val, i+1, sum+val[i]);
		int case2 = helper(cap, wt,val, i+1, sum);
		
		map.put(key, Math.max(case1,case2));
		return Math.max(case1,case2);
		
	}

//TC  - number of weights * capacity
//S.C = O(max,number of weights, capacity) + Hashmap isze = O(n) linear time
	
	
	
	
	
	
	
	
	public static void main(String args[]) 
    { 
    int item_val[] = new int[]{60, 100, 120}; 
    int item_wt[] = new int[]{10, 20, 30}; 
    int  W = 50; 
    int n = item_val.length; 
    System.out.println(knapSack(W, item_wt, item_val, n)); 
    } 

}
