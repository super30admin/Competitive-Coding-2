//Time Complexity: O(n * w) n is number of weights and w is the capacity 
// Space Complexity:O(n * w) n is number of weights and w is the capacity  
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class knapsack {
    static int knapsack(int W, int wt[], int val[], int n){
        //base
        if(n==0){
            return  0;
        }
        if(wt[n-1]<= W){
            return Math.max(knapsack(W-wt[n-1],wt,val,n-1),val[n-1] + knapsack(W-wt[n-1],wt,val,n-1));
        }
        else{
            return knapsack(W,wt,val,n-1);
        }
    }
    public static void main(String[] args) {
        int val[] = new int[] {60,100,120};
        int wt[] = new int[] {10,20,30};
        System.out.println(knapsack(50,wt,val,3));
    }
}