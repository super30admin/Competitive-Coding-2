//Question: 2.Knapsack problem

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Any problem you faced while coding this : no.
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// Idea here is to calculate the max gain in each scenario as maximum between the previously obtained 
// gain and gain from one step back. 

#include<vector>
#include <iostream>

int knapSack(int cap, std::vector<int>& weights, std::vector<int>& profit) {
    std::vector<std::vector<int>> result(weights.size()+1, std::vector<int>(cap+1, 0)); 
    for(int i = 1; i <= weights.size(); i++)
    {
        for(int j = 1; j <= cap; j++)
        {
            if(weights[i] > j)
            {
                result[i][j] = result[i-1][j];
            }
            else
            {
                result[i][j] = std::max(result[i-1][j], (profit[i] + result[i-1][j-weights[i-1]]));
            }
        }
    }
    return result[weights.size()][cap];
}


// Driver code 
int main() 
{ 
    std::vector<int> profit = { 60, 100, 120 }; 
    std::vector<int> weight = { 10, 20, 30 }; 
    int capacity = 50; 
    int n = profit.size();
    if(n == 0)
    {
        return 0;
    }

    if(n == 1)
    {
        return weight[0];
    }
    std::cout << "Max gain is: " << knapSack(capacity, weight, profit) << std::endl; 
    return 0; 
}
