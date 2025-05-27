/*
  Time complexity: O(n)
  Space complexity: O(1)

  Code ran successfully on leetcode: Yes

*/
public class Solution {
    public int[] TwoSum(int[] numbers, int target) { 
        int l = 0;
        int r = numbers.Length-1;

        while(l<r)
        {
            int num = numbers[l]+numbers[r];
            if(num==target)
            {
                return new int[2]{l+1,r+1};
            }
            else
            {
                if(num<target)
                {
                    l++;
                }
                else
                {
                    r--;
                }
            }
        }
        return new int[0];
    }
}
