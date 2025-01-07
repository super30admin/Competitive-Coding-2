/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var mp=new Map();
     for(let i=0;i<nums.length;i++){
        if(mp.has(target-nums[i])){
             return [i, mp.get(target-nums[i])];
        }
        mp.set(nums[i],i);
     }
      return [];
 };