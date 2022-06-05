// Two Sum

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
    let storageHash = {};
    let val = [];

    for (let i = 0; i < nums.length; i++) {
        let addend = target - nums[i];
        if (addend in storageHash) {
            val.push(storageHash[addend]);
            val.push(i);
        }
        storageHash[nums[i]] = i;
    }
    return val;
};