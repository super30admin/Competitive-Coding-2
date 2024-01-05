//TC O 2powN SC On
class Knapsack {
    public static void main(String[] args) {

        int weight[] = new int[] { 2, 3, 4,5 };
        int profit[] = new int[] { 1, 2, 5,6 };
        int W = 8;
        int n = profit.length;
        System.out.println(knapSack(W, weight, profit, n));
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        return helper(W, val, wt, n, 0, 0);}

    private static int helper(int remaining_capacity, int[] val, int[] wt, int n, int index, int maxProfit) {
 //Base Case

        if (index >= n || remaining_capacity == 0)

        return maxProfit;
        if(wt[index]>remaining_capacity){
            return helper(remaining_capacity,val,wt,n,index+1,maxProfit);
        }

        //choose
        int c1=helper(remaining_capacity-wt[index],val,wt,n,index+1,maxProfit+val[index]);
      //  no choose
        int c2=helper(remaining_capacity,val,wt,n,index+1,maxProfit);
        return Math.max(c1,c2);
    }
}

