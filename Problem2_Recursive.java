/*** Time Complexity: O(2^n) where n is the number of weights
 * Space Complexity : O(n) where n the longest branch of the tree
 * issues faced while coding : none
 */
class KnapsackRecursive {
     public static int maxProfit(int[] wt,int[] profit,int capacity,int n)
     {
        if(n==0 || capacity==0) return 0; //base case, capacity=0 means the knapsack is empty and n=0 means there are no weights
        if(wt[n]>capacity) return maxProfit(wt, profit, capacity, n-1); // if weight is more than remaining capacity we cant choose that weight.
        else
        {
            //case1 : we choose not include weight at a specific index in our optimal solution
            //case 2: we choose to include weight at a specific index in our optimal solution
            return Math.max(maxProfit(wt, profit, capacity, n-1),profit[n]+maxProfit(wt, profit, capacity-wt[n], n-1));
        }
     }
    public static void main (String[] args) {	
        int val[] = new int[] {60,100,120};
        int wt[] = new int[] {10,20,30}; 		
        int W = 50;			
        System.out.println(maxProfit(wt,val,W,wt.length-1));			
        }
}