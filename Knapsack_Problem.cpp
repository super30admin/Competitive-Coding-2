// Time Complexity : O(n * m)  
//                   ...  n is number of weights
//                   ...  m is amount of required weight
// Space Complexity :  O(n * m)   

/*
Geek-for-geeks : https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0
*/

// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>

int maxProfit (std::vector<int> &wt, std::vector<int> &pf, int amount){
    if(wt.size() == 0) return 0;
    
    int size = wt.size();
    std::vector<std::vector<int>>dp(size+1, std::vector<int>(amount+1, 0));

    for(int i=1; i<dp.size(); i++){
        for(int j=1; j<= amount; j++){
            if(wt[i-1] > j){
                dp[i][i] = dp[i-1][j];
            } else {
                dp[i][j] = std::max(dp[i-1][j], pf[i-1]);
            }
        }
    }
    int maxVal = 0;
    for(int i=1; i<=size; i++){
        maxVal = std::max(maxVal, dp[i][amount]);
    }
    return maxVal;
    
}

int main() {
    //std::vector<int> weights{4,5,1};
    //std::vector<int> profit{1,2,3};
    //int W = 4;
    
    std::vector<int> weights{4,5,6};
    std::vector<int> profit{1,2,3};
    int W = 3;
    
    int result = maxProfit(weights, profit, W);
    std::cout << "Maximum profit = " << result << std::endl;
    
    return 0;
}