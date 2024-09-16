

// here the time complexity is O(n) and space complexity is o(n)
// here first we are putting the elements in the hashmap along with their indices then in the next loop we are checking if compliment is there in hashmp or not and also checking
//if its index is not equal to the index of nums[i] then we are returning an array with their indices.
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mapp=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            mapp.put(nums[i],i);
        }
            for(int i=0;i<nums.length;i++)
        {
              int compliment=target-nums[i];
                if(mapp.containsKey(compliment) && mapp.get(compliment)!=i)
                {
                    return new int [] {i,mapp.get(compliment)};
                }
         }
        return new int [] {-1,-1};

    }
}
