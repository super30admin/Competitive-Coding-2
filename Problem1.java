Time complexity: O(n*W)
Space complexity:O(n*W)


class Solution 
{ 

    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int [][] arr = new int[n+1][W+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=W;j++)
            {
                if(i==0 || j==0)
                {
                    arr[i][j] = 0;
                }
                else if(wt[i-1]>j)
                {
                    arr[i][j] = arr[i-1][j];
                }
                else
                {
                    arr[i][j] = Math.max(val[i-1] + arr[i-1][j-wt[i-1]],arr[i-1][j]);
                }
            }
        }
        return arr[n][W];
    } 
}


