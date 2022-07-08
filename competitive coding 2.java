// "static void main" must be defined in a public class.
public class Main {
    
    public static int knapSack(int W, int[]wt, int[]val, int n)
    {
        if (n<=0||W<=0) return 0;
        
        int [][] matrix = new int [n+1][W+1];
        
        for(int j=0; j<=W; j++)
        {
            matrix[0][j]=0;
        }
        for(int i=1; i<=n; i++)
        {
            for (int j=1; j<=W; j++)
            {
                if(wt[i-1]>j)
                {
                    matrix[i][j]=matrix[i-1][j];
                }
                else
                {
            matrix[i][j]=Math.max(matrix[i-1][j], matrix[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }
        return matrix[n][W];
    }
    public static void main(String[] args) {
        int val[]= new int [] {150,100,120};
        int wt[] = new int [] {10, 20, 30};
        int W = 50;
        int n = val.length;
       
        System.out.println( knapSack(W, wt, val, n));
    }
}