// Time Complexity : O(mn)  m=no. of rows n=no. of columns
// Space Complexity :o(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr= new int[m][n];
        
        for(int i=0;i<n;i++)
        {  arr[m-1][i]=1;}
        
        for(int i=0;i<m;i++)
        {  arr[i][n-1]=1;}
    
        
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-2;j>=0;j--)
            {
             arr[i][j]=arr[i+1][j]+arr[i][j+1];     
            }
        }
        return arr[0][0];
    }
}