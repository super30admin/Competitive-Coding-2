//Time complexity - O(2^n)
//Space complexity - O(1)
// this is a recursive solution for knap sack problem.


public class KnapSack {

    public static int knapSack(int maxCapacity, int weightsArr[], int valuesArr[],int n) {

        //null case 
        if(weightsArr == null || valuesArr == null || valuesArr.length == 0|| weightsArr.length == 0) {
            return 0;
        }

        return helper(maxCapacity,weightsArr, valuesArr,n, 0,0);
    }

    public static int helper(int remainingCap, int weightSArr[], int valuesArr[],int n, int index, int maxProfit) {
        //base case
        if(index >= n || remainingCap == 0) {
            return maxProfit;
        }
        //logic
        if(weightSArr[index] > remainingCap) {
            return helper(remainingCap,weightSArr,valuesArr,n,index+1,maxProfit);

        }
        //choose weight
        int case1 = helper(remainingCap-weightSArr[index],weightSArr,valuesArr,n, index+1,maxProfit+valuesArr[index]);
        //do not choose weight
        int case2 = helper(remainingCap,weightSArr,valuesArr,n,index+1, maxProfit);
        return Math.max(case1,case2);

    }

    public static void main(String[] args) {

        int val[] = new int[] { 1, 2, 6 };
        int wt[] = new int[] { 2, 3, 5 };
        int W = 8;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}


