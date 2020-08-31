    /*  Explanation
    # Leetcode problem link : NA
    Time Complexity for operators : o(m*n)
    Extra Space Complexity for operators : o(m*n) .. 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Followed the choose and don't choose approach as suggested in image. And found the repatative sub problem.

        # Optimized approach: . 
                              
            # 1. Form the two matrix. colum will be for capacity and row will be for weights
                 the matrix will contains the values of profit.
              2. First row and colum will be 0 as we cannot form the sum with the given value with 0 weights and vice-versa
                 (we cannot get 0 capacity with the available weights).
              3. Starting from first row and column, we will find the max of Choose and don't choose. If we don't choose that emans we will
                 get the options/weights from previous array.
              4. If we choose the weight, then we will select the rest of the weights from (previous row -  value of weight). The max of (point no  3,point no 4)
                 will be the value of current position
              5. At the end, we will return the last element that tell lus the required o/p


    */


public class Problem2{
    public static void main(String args[]) {
                int prof[]= new int[] {1,2,6};
                int wt[]= new int[] {2,3,5};
                int cap = 8;
                System.out.println(maxProfit(prof,wt,cap));
            }
            
            
            
        public static int maxProfit(int prof[],int wt[],int capacity) {
                
                int DP[][] = new int[wt.length+1][capacity+1];
                for(int i=0;i<capacity+1;i++) {
                    DP[0][i] = 0;
                }
                for(int i=0;i<wt.length+1;i++) {
                    DP[i][0] = 0;
                }
                
                for(int i=1;i<wt.length+1;i++) {
                    for(int j=1;j<capacity+1;j++) {
                        if(j < wt[i-1]) {
                            DP[i][j] = DP[i-1][j];
                        }else {
                            DP[i][j] =  Math.max(DP[i-1][j], (prof[i-1]+ DP[i-1][j-wt[i-1]]));
                        }
                    }
                }
                return DP[wt.length][capacity];
           }
}
