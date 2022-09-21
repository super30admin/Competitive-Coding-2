// Time Complexity : O(n) n is the length of array nums
// Space Complexity : O(n) n is the length of array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
    // If nums is invalid or is Empty
    if(nums===null || nums.length===0)
        return [-1, -1];
    
    // Map to store the number and its index
    let map = new Map();
    for(let i=0; i<nums.length; i++){
        let num = nums[i];
        let diff = target - num;
        if(map.has(diff)){
            return [i, map.get(diff)];
        } else {
            map.set(num, i);
        }
    }
    return [-1, -1];
    
};
