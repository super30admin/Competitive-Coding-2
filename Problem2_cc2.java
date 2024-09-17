public class Main {
    public  static  int knapSack(int W,int[] weights, int[] vals){
    int[][]cache = new int[weights.length+1][W+1];
    for(int i=1;i<= weights.length; i++){
        for(int j=1;j<=W;j++){
        if(weights[i-1]>j)
            cache[i][j] = cache[i-1][j];
        else
            cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-weights[i-1]] + vals[i-1]);
    }
    }
    return cache[weights.length][W];
} 
    public static void main(String[] args) {
        //System.out.println("Hello World!");
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val));
        
        int max = knapSack(5,wt,val);
    }
}