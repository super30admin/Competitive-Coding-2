// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/** @format */

var twoPointer = function(arr, target) {
    let hashObj = {}
    for(let i = 0; i < arr.length; i++) {
        hashObj[arr[i]] = i;
    }
    for(let i = 0; i < arr.length; i++){
        let diff = target - arr[i];
        if(hashObj.hasOwnProperty(diff) & hashObj[i] !== i){
            return [i,hashObj[diff]];
        }
    }
}

console.log(twoPointer([2, 7, 11, 15], 9));