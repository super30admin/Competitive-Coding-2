// A Dynamic Programming based solution
//Time Complexity: O(n * TotalWight).
//Space Complexity: O(n * TotalWight).
class Knapsack {
 
    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int totalWeight, int weight[],
                        int value[])
    {
        int n = value.length; 
        int i, w;
        int sack[][] = new int[n + 1][totalWeight + 1];
 
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= totalWeight; w++)
            {
                if (i == 0 || w == 0)
                    sack[i][w] = 0;  //fill the first row and col with zeros
                
                else if (weight[i - 1] <= w)
                    sack[i][w]
                        = Math.max(value[i - 1]
                         + sack[i - 1][w - weight[i - 1]],
                         sack[i - 1][w]);
                else
                    sack[i][w] = sack[i - 1][w];
            }
        }
 
        return sack[n][totalWeight];
    }
 
    // Driver code
    public static void main(String args[])
    {
        int value[] = new int[] {1, 4, 5, 7};
        int weight[] = new int[] {1, 3, 4, 5 };
        int totalWeight = 7;
        System.out.println(knapSack(totalWeight, weight, value));
    }
}
