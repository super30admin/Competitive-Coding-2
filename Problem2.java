//Kanpsack Exhaustive
// "static void main" must be defined in a public class.
public class Main {
    public static int maxProfit(int[] profits, int[] weights, int capacity)
    {
        //null
        if(profits==null || weights==null) return -1;
        return helper(profits,weights,capacity,0,0);
    }
    private static int helper(int[] profits, int[] weights, int capacity,int idx,int sum)
    {
        if(idx >= profits.length || weights[idx] > capacity )return sum;
        //choose
        int case1 = helper(profits, weights, capacity-weights[idx],idx+1,sum+profits[idx]);
        //don't choose
        int case2 = helper(profits, weights, capacity,idx+1,sum);
        return Math.max(case1,case2);
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] profits = {60,90,120};
        int[] weights = {10,20,30};
        System.out.println(maxProfit(profits,weights,50));
    }
}