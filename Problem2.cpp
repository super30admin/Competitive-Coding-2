// Time Complexity O(m*n)
// Space complexity O(m*n)

#include <vector>
#include <iostream>

using namespace std;

class Solution {
    int helper(int idx, int n, const vector<int>& values, const vector<int>& weights, int capacity, vector<vector<int>>& memo) {
        // base        
        if (idx >= n) {
            return 0;
        }

        // recursive
        if (memo[idx][capacity] != -1) {
            return memo[idx][capacity];
        }
        int zero = helper(idx+1, n, values, weights, capacity, memo);
        int one = -999999;
        if (capacity - weights[idx] >= 0) {
          one = values[idx] + helper(idx+1, n, values, weights, capacity-weights[idx], memo);
        }
        memo[idx][capacity] = max(zero, one); 
        return memo[idx][capacity];
    }

public:
    int max_profit(const vector<int>& values, const vector<int>& weights, int capacity) {
        int n = values.size();
        vector<vector<int>> memo(n, vector<int>(capacity+1, -1));
        return helper(0, n, values, weights, capacity, memo);
    }
};

int main()
{
    Solution sol;
    std::vector<int> values = {60, 100, 120};
    std::vector<int> weights = {10, 20, 30};
    int capacity = 50;
    
    std::cout <<  sol.max_profit(values, weights, capacity) << "\n";

    return 0;
}