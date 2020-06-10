/**
 * Same as Coin Change 1 --consider , dont consider with constraint on weight
 */
class Trial{
    public static int findMaxCap(int W,int[] wt,int[] val, int n,int max){
        if(wt == null|| val == null || wt.length == 0 || val.length == 0 || wt.length != val.length) return 0;

        //base
        if(n==wt.length || W==0) return max;
        //choose
        int case1 = 0;
        if(wt[n] <= W)
            case1 = findMaxCap(W-wt[n],wt,val,n+1,max+val[n]);
        //dont choose
        int case2 = findMaxCap(W,wt,val,n+1,max);
        return Math.max(case1,case2);
    }
    public static void main(String[] args){
        int[] wt = new int[] {10,20,30};
        int[] val = new int[] {60,100,120};

        System.out.println(findMaxCap(50,wt,val,0,0));
    }
}