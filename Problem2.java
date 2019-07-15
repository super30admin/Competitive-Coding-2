import java.util.*;
public class problem2 {

    static int max(int a, int b) { 
         if(a>b) return a;
         else return b;
    } 
       
     static int knapSack(int W, int wt[], int val[], int n) 
     { 
        if (n == 0 || W == 0) return 0; 
        if (wt[n-1] > W) {
            return knapSack(W, wt, val, n-1); 
        }
        else {
            return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1) ); 
        }
    } 

    public static void main(String[] args) {
        int[] value = {60,100,120};
        int[] weight = {10,20,30};
        int W = 50;
        System.out.println(knapSack(W, weight, value, value.length));    
}
}