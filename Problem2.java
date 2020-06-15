// Time Complexity :O(n*m) n is the length of the array and m is the max weight
// Space Complexity : O(n*m) n is the length of the array and m is the max weight
// Did this code successfully run on Leetcode :Yes

// Your code here along with comments explaining your approach

class Problem2{
    public static void main(String[] args) {
    int val[]= new int[]{6,10,12};
	int wt[] = new int[]{1,2,3};
	int W = 5;
	int n = val.length;
    System.out.println(knapSack(W,wt,val,n));
    
  

    }

    private static int knapSack(int W,int[] wt,int[] val, int n){
        
        int row = W +1;
        int col = wt.length +1;
        int[][] arr = new int[col][row];
        for(int i = 0; i<col;i++){
            arr[i][0] = 0;
        }
        for(int j = 1; j<row;j++){
            arr[0][j] = 0;
        }

        for(int i =1;i<col;i++){
            for(int j = 1; j<row;j++){
                if(wt[i-1]<=j){
                    arr[i][j] = Math.max(arr[i-1][j],arr[i-1][j-wt[i-1]]+val[i-1]);
                }
                else{
                    arr[i][j] = arr[i-1][j];
                }
                
            }
        }

        return arr[col-1][row-1];
    }

}