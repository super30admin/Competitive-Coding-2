//tc:
//sc:

class knapsack{

static int max(int a, int b)
return (a>b)? a:b ;

}

static int knapSack(int W, int wt[], int value[], int)
{

int i,w;
int dp[][] = new int [n+1][w+1];

for(i=0; i< =n; i++){
for(w=o;w<= W; w++){
if(i==0 || w==0)
dp[i][w]=0;
else if(wt[i-1]<=w)
dp[i][w] = max(value[i-1] + dp[i-1][w-we[i-1]], dp[i-1][w]):
else
dp[i][w] = K[i-1][w];
}
}
return dp[n][w];
}

public static void main(String args[]) 
    { 
        int value[] = new int[] { 60, 100, 120 }; 
        int wt[] = new int[] { 10, 20, 30 }; 
        int W = 50; 
        int n = val.length; 
        System.out.println(knapSack(W, wt, value, n)); 
    } 
} 