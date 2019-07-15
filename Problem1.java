time complexity is O(n)
Space complexity is  happy case : constant result arrya. worst case : ending up all element to map O(n).

class solution{

public int[] sum(int[] data , int target){

     Map<Integer, Integer> map = new HashMap<>();  
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];   // check whether the target's compliment ie. target - eleme is in map, if yes, return the indices else keep in map. 
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
 }

}

