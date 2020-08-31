// Time Complexity : O(n)
// Space Complexity : O(n) as we are using an extra hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


// Your code here along with comments explaining your approach


#include<iostream>

#include<map>
#include<vector>
using namespace std;

int factors(vector<int> & nums, int target){

	map<int , int> myhash;
	static int result[1];

for( int i=0; i<nums.size(); i++){
    if (target%nums[i]==0){
    	myhash.insert({nums[i],target / nums[i]});
    }
}

for ( int i=0; i<nums.size(); i++){
	if(myhash.count(nums[i])){
		if(myhash.count(myhash.at(nums[i]))){

		cout<<"the factors are "<< nums[i]<<" and "<< myhash.at(nums[i]);
		
		return 1;
		}
	}
}

return 0;
}

int main(){

	vector<int> arr = {1,2,3,4,5};
	int tar = 7;
	int result = factors(arr,tar);
	if (result!=1)
		cout<< "there is no solution"<<endl;
	return 0;
}