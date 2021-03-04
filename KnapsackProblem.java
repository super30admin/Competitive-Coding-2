
public class KnapsackProblem {

	//TC - o(2^n)
	//SC- o(n)
	private static int knapSack(int w, int[] wt, int[] val, int index) {
		
		//base
		if(index >= val.length || w == 0)
			return 0;
		
		//logic
		if(w < wt[index]) 
			return knapSack(w,wt,val,index+1);
		//not choose
		int notChoose = knapSack(w,wt,val,index+1);
		//choose
		int choose = knapSack(w-wt[index],wt,val,index+1)+val[index];

		return Math.max(notChoose, choose) ;
	}

	public static void main(String[] args) {

		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 10, 30 };
		int W = 40;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, 0));
	}

}
