public class Solution2Sum {
    class Solution2Sum {
        public static int[] twoSum(int[] nums, int target) {
    
            Map<Integer,Integer> map = new HashMap();
    
            for(int i=0;i<nums.length;i++)
            {
                if(map.containsKey(target-nums[i]))
                {
                    return new int[]{map.get(target-nums[i]),i};
                }
    
                map.put(nums[i],i);
            }
    
            return new int[]{-1,-1};
        }
    
    
        public static void main(String[] args)
        {
            int[]nums = {2,7,11,15}; 
            int target = 9;
            int output[]=twoSum(nums, target);
    
    
                System.out.println(" first index "+output[0]+"   second index "+output[1]);
    
        }
    }
