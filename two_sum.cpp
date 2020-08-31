
// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an extra hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


// Your code here along with comments explaining your approach



class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
     map<int , int> myhash;
	vector<int> result(2,0);

for( int i=0; i<nums.size(); i++){
   
    	myhash.insert({nums[i],i});

}

for ( int i=0; i<nums.size(); i++){

		if(myhash.count(target -nums[i]) && i != myhash.find(target - nums[i])->second ){

		cout<<"the factors are "<< i <<" and "<< myhash.find(target - nums[i])->second;
		result[0] = i;
        result[1] = myhash.find(target - nums[i])->second;
		return result;
		}

}

return result;
}   
        
};