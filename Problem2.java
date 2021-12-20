
//Time Complexity: O(n)
//Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class KnapSack1{
    public static int KnapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity){
        int[][] lookuptable = new int[profitsLength + 1][capacity + 1];
        int i,w;
        if(capacity <= 0 || profitsLength != weightsLength || profitsLength == 0 )
            return 0;
        for(i = 0; i <= profitsLength; i++){
            for( w = 0; w<=capacity; w++){
                if(i == 0 || w == 0)
                    lookuptable[i][w] = 0;
                else if(weights[i - 1] <= w)
                    lookuptable[i][w] = Math.max(profits[i-1] + lookuptable[i - 1][w - weights[i - 1]], lookuptable[i-1][w]);
                else
                    lookuptable[i][w] = lookuptable[i-1][w];
            }
        }
        return lookuptable[profitsLength][capacity];
    }
    public static void main(String[] args){
        int profits[] = {1, 6, 10, 16};
        int weights[] = {1, 2, 3, 5};
        System.out.println("Total knapsack profit ---> " + KnapSack(profits, 4, weights, 4,  7));
        System.out.println("Total knapsack profit ---> " + KnapSack(profits, 4, weights, 4, 6));
    }
}
