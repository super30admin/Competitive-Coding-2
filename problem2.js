//Time: O(n), Space:O(n)
var findPairs = function(nums, k) {
    if(nums.length == 0 ) return 0;
    let hash_map = {};
    let count = 0;
    for(let i=0;i<nums.length;i++){
        if(k == 0){
            if(!(nums[i] in hash_map)){
                hash_map[nums[i]] = 1;
                continue;
            }else{
                hash_map[nums[i]] = hash_map[nums[i]] + 1;
                if(hash_map[nums[i]] > 2){
                    continue;
                }
            }
            let diff1 = nums[i] + k;
            if(diff1 in hash_map){
                count++;
            }
            continue;
        }
        if(nums[i] in hash_map){
            continue;
        }
        let diff1 = nums[i] + k;
        let diff2 = nums[i] - k;
        if(diff1 in hash_map){
            count++;
        }
        if(diff2 in hash_map){
            count++;
        }
        hash_map[nums[i]] = i;
    }
    return count;
};