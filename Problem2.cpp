//Time complexity is O(2^n)
//Space complexity is O(1)

/*Approach:
We first try the exhaustive approach. In that exhaustive approach we make two cases i.e
Choose case and not choose case. */

class Solution{
    public:
     int knapSack(int capacity, vector<int> weight, vector<int> profit, int size){
        return helper(capacity, weight, profit, 0, 0 ,size);
    }

    private:
    int helper(int remainingCapacity, vector<int> weight, vector<int> profit, int earnedProfit, int index, int size){
	
	//base case
	if(remainingCapacity == 0 || index >= weight.size()) return earnedProfit;
	//logic
    if(weight[index] > remainingCapacity) return helper(remainingCapacity, weight, profit, earnedProfit , index + 1, size);
	int case1 = helper(remainingCapacity - weight[index], weight, profit,
     profit[index] + earnedProfit, index + 1, size);
	int case2 = helper(remainingCapacity, weight, profit, earnedProfit, index + 1,size);
	return max(case1, case2);
}
    
};


//Time complexity is O(N*capacity)
//Space complexity is O(N*capacity)

/*Approach:
We found subproblems in the exhaustive approach with help of which we try to solve it with dynamic programming.
We created a table of  N*capacity. Then  we noticed that until the value of the capacity is less than the current
weight we can simply copy the results of the previous row. Otherwise, we have to take the maximum of the result of 
the previous row for the current column and sum of value earlier calculated in the same row at current weight equivalent
steps back and the profit for current index.*/

//The code calculated the answer without any errors.

class Solution{
    public:
     int knapSack(int capacity, vector<int> weight, vector<int> profit, int size){
         vector<vector<int>> mat(size+1 , vector<int> (capacity + 1));
         int r = mat.size();
         int c = mat[0].size();
         mat[0][0] = 0;
         for(int i = 1; i<r; i++) {
             for(int j = 1; j<c ; j++){
                 if(j < weight[i - 1]){
                     mat[i][j] = mat[i-1][j];
                 } else {
                     mat[i][j] = max(mat[i-1][j], mat[i-1][j - weight[i-1]] + profit[i-1]);
                 }
             }
         }

         return mat[r-1][c-1];
     }

};
