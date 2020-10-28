//Time O(n*W)
//Space O(n*W) for creating dp array
Class Problem2
        {
    int knapSack(int W, int wt[], int val[], int n)
        {
        int i,w;
        int K[][]=new int[n+1][W+1];

        for(i=0;i<=n;i++)
        {
            for(j=0;j<=W;j++)
            {
                if(i==0||w==0)
                K[i][w]=0;
                else if(wt[i-1]<=w)
                K[i][w]=max(
                val[i-1]+K[i-1][w-wt[i-1]],
                K[i-1][w]);
                else
                K[i][w]=K[i-1][w];
            }
        }

         return K[n][W];
        }

        }