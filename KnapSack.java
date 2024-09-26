class KnapSack {
    public int knapSack(int capacity, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][capacity + 1];
 
        //bottom up approach
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= capacity; w++)
            {
                if ( i == 0 || w == 0 ) {
                    K[i][w] = 0;
                }
                else if ( wt[i - 1] <= w ) {
                    K[i][w] = max( val[i - 1] + K[i - 1][w - wt[i - 1]] , K[i - 1][w] ); //maximizing the profit
                }
                else
                    K[i][w] = K[i - 1][w];
            }
        }
 
        return K[n][capacity];
    }
}