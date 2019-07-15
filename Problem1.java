import java.util.HashMap;

public class Problem1 {
	
	public static int[] find(int[]arr, int target) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length;i++) {
			int compliment = target - arr[i];
			if(map.containsKey(compliment)) {
				return new int[] {map.get(compliment),i};
			}
			
			map.put(arr[i],i);
			
		}
		return new int[] {-1,-1};
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,7,11,15};
	    int answer[] = find(arr,13);
	    System.out.println(answer[0] + " " + answer[1]);

	}

}