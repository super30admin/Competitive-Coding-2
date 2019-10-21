import java.util.*;
public class Main {
    public static void main(String[] args) {
        int wt[]={1,2,3};
        int val[]={6,10,12};
        int cap=5;
        System.out.println(knapsack(wt,val,cap));
    }
    public static int knapsack(int wt[],int val[],int cap){
        int n=wt.length;
        
        int [][]kp=new int[n+1][cap+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=cap;j++){
                if(i==0 || j==0)
                {
                    kp[i][j]=0;
                }
                else if(j>=wt[i-1]){
                    kp[i][j]=Math.max(val[i-1]+kp[i-1][j-wt[i-1]],kp[i-1][j]);
                }
                else kp[i][j]=kp[i-1][j];
                
            }
        }
        return kp[n][cap];
    }
    
}
TC:O(mxn)
SC:O(mxn)
Approach Dynamic programming
