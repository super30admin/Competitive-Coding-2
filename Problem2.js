//Name: Two Sum
//Question:  https://leetcode.com/problems/two-sum/
//Time Complexity: O(N) where N = size of the array
//Space Complexity: O(1)

//Code: 
var twoSum = function(nums, target) {
    //Create a hashmap
    var prevOccurance = {};
    var finalArr = []
    nums.forEach((val, index) => {
        //if the difference between current value and target doesnt exist then add current value
        if(prevOccurance[target - val] != undefined) {
            finalArr = [prevOccurance[target - val], index];
        }
        else {
            //if the value exists then access it and get the index(key inside the hashtable)
            prevOccurance[val] = index;
        }
    })
    return finalArr;
};
