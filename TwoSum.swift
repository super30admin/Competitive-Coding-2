//
//  TwoSum.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 1/6/26.
//

/*
 want unique pairs
 can think elemets as pairs. Used for
 two pointers
 
 -> naive approach- O(n2) -> nested iterations
 approach 2 - use hash map. Search for compliment in
 
 -> O(n) time complexity. Space - O(n)
 use hash set. and only store numbers or compliment. store number and look for compliment. or vice versa
 
->  binary search - sort the array. Do binary search for compliment.
 
 ->If array is already sorted. time complexity - O(n logn)
 for each element we are doingnbinary serahc. So log n for all elements of an array. -> n logn
 to sort the array - O(n log n)
 time complexity - O(n logn n) + O(n log n) = O(n log n) (avoid constant)
 
 -> Two pointer - keep on increasing the pointer 1 and decreasing the pointer 2
 n log  n for sortuing. O(n) for two pointers
 
 => If I have repeats in the numbers array but we don't want repeats in pair.
 [-3, 0, -2, -2, -1, -1, 0, 0, 0 7, 7, 6, 1, 1, 9, 9 ,9, -1, 0]
 1. can use hash set to avoid duplicated of a pair. O(n) space complexity.
 
 2. Sort the array and use two pointers solution.
 [-4, -3, -2, -2, -1, -1, -1, 0, 0 , 0, 1, 1, 1, 2, 2  ]
 O (n logn n), no extra space
 right pointer value + left pointer value > target, decrease right pointer.
 ----- < target, increase left pointer to have bigger value to make bigger sum
 If we are at the target -> move both the pointers and record the pair.
 Move the left and right pointers until we hit the next unique element. In this way, we avoided hash set for storage
 
 Nested iterations can be optimizied using
 binary search, hashing, two pointers,
 
 
 -> 3 sum -> 1 fixed pointer and two sum
 -> 4 sum - > take 2 pivots. and 2 pointers
 
 */

class TwoSum {
    
    init() {
        let resultIndex = twoSum(nums: [2,7,11,15], target: 13)
        print("resultIndex \(resultIndex)")
    }
    
    func twoSum(nums: [Int], target: Int) -> (Int, Int){
        var map: Dictionary<Int, Int> = [:]
        for i in 0..<nums.count {
            map[nums[i]] = i
        }
        
        for j in 0..<nums.count {
            let complement = target - nums[j]
            //If the complment exists in hash map and the index for that number is not equal to the current processed index means these two numbers are placed at different index.
            if (map[complement] != nil && map[complement] != j) {
                return (j, map[complement]!)
            }
        }
        return (-1, -1)
    }
}
