public class Knapsack2 {

    public static void main(String[] args) {

        int weight[] = new int[] { 2, 3, 4,5 };
        int profit[] = new int[] { 1, 2, 5,6 };
        int W = 8;
        int n = profit.length;
        System.out.println(find(W, weight, profit, n));
    }
    static int find(int W, int wt[], int val[], int n) {
       if(n==0 || W==0){
           return 0;}
       if(W<wt[n-1]){
           return find(W, wt, val, n - 1);
       }

      int c1= val[n-1]+find(W-wt[n-1],wt,val,n-1);
      int c2=find(W,wt,val,n-1);
      int re=Math.max(c1,c2);
      return re;



    }
}
