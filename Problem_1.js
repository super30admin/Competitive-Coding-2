// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Brute force method was to run two for loops and check a elemenet with every other element in the array, if a pair if found that sums to a target, we return the index of the elements.
// Optimized approach is to use a hash map for quick retrieval, I run a for loop for the length of the array, for each element if target - element is present in hash map, 
// return element index and value of returned value from hash map, else store the element and index pair in hash map and iterate. 

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {

    let targetMap = new Map();
    let res = [-1, -1]
    for(let i = 0; i < nums.length; i++){
        let diff = target - nums[i];
        if(targetMap.has(diff))
            res = [targetMap.get(diff) , i];
        else
            targetMap.set(nums[i], i);
    }
    return res;
};

let q = [2,7,11,15];
let target = 9
let qRes = [0,1]
console.log('Expected result: ', qRes);
console.log( 'Actual result : ',twoSum(q, target) )