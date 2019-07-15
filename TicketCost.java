// Time complexity : O(m) - m is maximum days 
// Space complexity : O(m) 

import java.util.HashSet;

class TicketCost {
    public int mincostTickets(int[] days, int[] costs) {

        int daysLimit = days[days.length-1];
        HashSet<Integer> eventDays = new HashSet<>();
        for(int i=0;i<days.length;i++){
            eventDays.add(days[i]);
        }
        int[] dp = new int[daysLimit+1];
        for(int i=1;i<=daysLimit;i++){
            if(!eventDays.contains(i)){
                dp[i] = dp[i-1];
            }
            else{
                int dayPassCost = 0, weeklyPass = 0, monthlyPass = 0;
                dayPassCost = dp[i-1] + costs[0];
                weeklyPass = Math.min(dayPassCost, (i-7 > 0 ? dp[i-7] : dp[0]) + costs[1]);
                monthlyPass = Math.min(weeklyPass, (i-30 > 0 ? dp[i-30] : dp[0]) + costs[2]);                
                dp[i] = monthlyPass;

            }

        }

        return dp[daysLimit];


    }
    public static void main(String[] args){
        System.out.println("Ticket cost");
        TicketCost obj = new TicketCost();
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2,7,15};
        System.out.println(obj.mincostTickets(days, costs));
    }
}