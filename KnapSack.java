time complexity : if the input array is not sorted , time complexity = O(nlogn) + O(n)(m) , where n is the input array length and m is the weight
                if the input array is sorted , time complexity = O(n)(m) , where n is the input array length and m is the weight

space  complexity :  O(n)(m) , where n is the input array length and m is the weight

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
class Pair{
    int wt,amount;
    Pair(int wt, int amount){
        this.wt=wt;
        this.amount=amount;
    }
}
public class Knapsack {
    private static int findMax(int[] inputWeightArray, int[] inputAmountArray, int maxWeight) {
        if(inputWeightArray==null || inputAmountArray==null || inputWeightArray.length==0 || inputAmountArray.length==0)
            return 0;
        List<Pair> listTmp = new LinkedList<Pair>();
        for(int i=0;i<inputWeightArray.length;i++)
            listTmp.add(new Pair(inputWeightArray[i],inputAmountArray[i]));
        Collections.sort(listTmp, (o1, o2) -> o1.wt - o2.wt);
        int[][] optArray = new int[inputWeightArray.length+1][maxWeight+1];
        for(int i=1;i<=listTmp.size();i++){
            for(int j=1;j<=maxWeight;j++){
                int tmpWeight = listTmp.get(i-1).wt;
                int tmpAmount = listTmp.get(i-1).amount;
                if(tmpWeight<=j) {
                    optArray[i][j] = Math.max(optArray[i - 1][j], optArray[i - 1][j - listTmp.get(i-1).wt] + tmpAmount);
                }
            }
        }
        return optArray[inputWeightArray.length][maxWeight];
    }
    public static void main(String[] args) {
        int[] inputWeightArray = {5,1,2,3};
        int[] inputAmountArray = {50,30,70,50};
        int maxWeight=5;
        System.out.println("The Max Weight is : \n" +findMax(inputWeightArray,inputAmountArray, maxWeight));
    }
}