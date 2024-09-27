// 2 sum
//tc n
//sc n
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Arrays.sort(nums);
        // for(int x : nums)
        // {
        //     System.out.print(x + " ");
        // }
//         int first=0, last=nums.length -1;
//         while(first<last)
//         {
//             if(nums[first]+nums[last]==target)
//             {
//                 return new int[] {first,last};
//             }
//             else if(nums[first]+nums[last]<target)
//             {
//                 first++;
//             }
//             else if(nums[first]+nums[last]>target)
//             {
//                 last--;
//             }
                
//         }
//         return new int[0];
        int[] result = {-1,-1};
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(target-nums[i]))
                {
                    result[0]=i;
                    result[1]=map.get(target-nums[i]);
                    return result;
                }
            map.put(nums[i],i);   
        }
        
 return result;       
}
}
