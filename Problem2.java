// Time Complexity : O(n*W)
// Space Complexity : O(n*W)

// Any problem you faced while coding this : No

class Solution1 {
    private int max(int x, int y){
        return (x>y)? x : y;
    }
    private int knapSack(int val[], int wt[], int W, int n){
        int k[][] = new int[n+1][W+1];
        for(int i=0; i<=n; i++ ){
            for(int j=0; j<=W; j++){
                if(i==0 || j==0){
                    k[i][j] = 0;
                }
                else if(wt[i-1] <= j){
                    k[i][j] = max(val[i-1] + k[i-1][j- wt[i-1]], k[i-1][j]);
                }
                else{
                    k[i][j] = k[i-1][j];
                }
            }
        }
        return k[n][W];
    }
    public static void main(String[] args) {
        Solution1 obj = new Solution1();
        int val[] = {60,100,120};
        int wt[] = {10,20,30};
        int W = 50;
        int n = val.length;
        System.out.println(val);
        System.out.println(obj.knapSack(val,wt,W,n));
    }
}