#include<iostream>
#include<vector>
#include <math.h> 
#define EPS 1e-9 
using namespace std;
// Time Complexity : O(N) for 
// Space Complexity : O(N) for Approach1 ,O(1) for Approach 2
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
vector<int> productExceptSelf(vector<int>& nums) {
    int size = nums.size();
    vector<int> output(size);
    vector<int> left(size);
    vector<int> right(size);

    left[0] =1;
    for(int i = 1; i < size; i++){
        left[i] = left[i -1] * nums[i - 1];
    }
    right[size - 1] =1;
    for(int i = size - 2; i >= 0; i--){
        right[i] = right[i + 1] * nums[i + 1];
    }
    for(int i =0; i < size; i++){
        output[i] = left[i] * right[i];
    }
    return output;

}

vector<int> productPuzzle(vector<int>& nums) {
    long double sum = 0;
    int size = nums.size();
    vector<int> output(size);
    for(int i =0; i < size; i++){
        sum += (long double)log10(nums[i]); 
    }
    cout<<output.size();
    for(int i =0; i < size; i++){
        output.push_back((int)(EPS + pow((long double)10.00, sum - log10(nums[i]))));
    }
    return output;   
}


int main(){
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(4);

    vector<int> out = productPuzzle(arr);
    cout<<out.size();
    for(int i=0; i < out.size(); i++){
        cout<<out[i]<<endl;
    } 
    return 0;
}