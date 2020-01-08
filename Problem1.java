// Time Complexity : Only one for loop is used traversing the length of the array i.e. 'n'. Two comparisons are done whose Time complexity is constant. All other hashmap operations are done in constant time. So Asymtotically, the Time complexity is in the order of O(n)
// Space Complexity : hashmap is the auxillary data structure used. In the worst case when no sum is present, the space complexity will be O(n) 
// Is this the most optimized approach  - Yes
// Other approaches - Brute force. Run two nested for loops, one from 0 to n and inner one from j = i+1 to n, check if element at i is equal to element at j
                                   //If true terminate and return i and j. Time complexity is O(n^2)

// Your code here along with comments explaining your approach


import java.util.HashMap;

class Problem1 {
    
    public int[] findSum(int[] nums, int target) {  
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums == null || nums.length == 0)   //edge case if array is empty.
            return new int[]{-1, -1};     
        for(int i =0; i < nums.length; i++)
        {
            if(!map.containsKey(Math.abs(nums[i] - target)))
            {   //if the compliment of the element is not in the array, put the element and its index
                map.put(nums[i], i);
            }
            else{  //if it is there, then return the value at compliments key and the current elements index
                int first = map.get(Math.abs(nums[i] - target));
                return new int[] {first, i};
            }
        }
    return new int[]{-1, -1};   //return if sum is not found
    }
}

// Class with main function
class Main
{
    public static void main(String[] args)
    {
    Problem1 obj = new Problem1();
    int[] input_array = {2, 3, 7, 5}; 
    int target = 9;
    int[] result = obj.findSum(input_array, target);
    for(int i =0; i < 2; i++)
    {System.out.println(target + " is present in the input array at index - " + result[i]); 
   }
    }
}

