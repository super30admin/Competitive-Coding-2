/* A Naive recursive implementation
of 0-1 Knapsack problem */
class Knapsack {

static	int val[] = new int[] { 60, 100, 170 };
static	int wt[] = new int[] { 20, 30, 50 };
static	int W = 50;
static	int n = val.length;
	static int max(int a, int b)
	{
	return (a > b) ? a : b;
	}

	static int knapSack(int W,int v,int index)
	{
	    // base
	    if(W==0)
	    {
	         return v;
	    }
	    
	    if (W<0)
	    return -1;
	    if(index==n)
	    {
	        return -1;
	    }
	 
	    //logic
	    //choose
	    int choose= knapSack(W-wt[index], v+val[index], index+1);
	    
	    //not choose
	    int not_choose= knapSack(W, v, index+1);
	    
	    return max(choose,not_choose);
	}

	// Driver code
	public static void main(String args[])
	{
		
		System.out.println(knapSack(W,0,0));
	}
}
