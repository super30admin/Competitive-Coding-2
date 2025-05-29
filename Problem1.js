//Two Sum
function twoSum(nums,target) {
    let hashMap = new Map()
    for(let num of nums){
        let complement = target - num;
        if(hashMap.has(complement)){
            return [nums.indexOf(num),hashMap.get(complement)]
        }
        else{
            hashMap.set(num,nums.indexOf(num))
        }
    }
    return -1
}

console.log(twoSum([2, 7, 11, 15],9))