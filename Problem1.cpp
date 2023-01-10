1 Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :



#include<iostream>
#include<map>
#include<iterator>


using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map <int,int> m;
        int j=0;
        vector <int> ret;
        vector <int>:: iterator i;
        for(i = nums.begin(); i!= nums.end(); i++) {
            m.insert(pair<int,int>(*i,j));
            int result2 = target-(*i);
            if((m.find(result2) != m.end()) && (m.find(result2)->second != j)) {
                ret.push_back(m.find(result2)->second);
                ret.push_back(j);           
            }
            j++;
        }
        return ret;
    }
};
