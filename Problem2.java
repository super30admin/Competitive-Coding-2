package github.com.Competitive_Coding_2;

import java.util.Set;
import java.util.HashSet;

/**
 * In a country popular for train travel, you have planned some train travelling
 * one year in advance. The days of the year that you will travel is given as an
 * array days. Each day is an integer from 1 to 365.
 * 
 * Train tickets are sold in 3 different ways: a 1-day pass is sold for costs[0]
 * dollars; a 7-day pass is sold for costs[1] dollars; a 30-day pass is sold for
 * costs[2] dollars.
 * 
 * The naive would be to enumerate all the possible purchase plan and pick the one with most efficient cost.
 * It is easy to visualize that this is bad and run time is O(3^n), where n is number of days
 * 
 *                  { Cost(n-1) + cost_1day_pass
 * Cost(n) = min of { Cost(n-7) + cost_7day_pass
 *                  { Cost(n-30) + cost_30day_pass
 * 
 * We could use dynamic programing to store solution to subproblems to above recurrence.
 * Time Complexity: O(3*n);     Pseudo Polynomial Runtime
 * Space Complexity: O(n)
 * 
 * Leetcode Results:
 * Runtime: 1 ms, faster than 93.94% of Java online submissions for Minimum Cost For Tickets.
 * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Minimum Cost For Tickets.
 */
public class Problem2 {
    /**
     * 
     * @param days  days of the year that you will travel
     * @param costs cost of 1 day, 7 day and 30 day ticket respectively
     * @return minimum number of dollars you need to travel every day in the given
     *         list of days.
     */
    public int mincostTickets(int[] days, int[] costs) {
        // to track the days of travel
        boolean[] included = new boolean[days[days.length - 1] + 1];
        for (int day : days) {
            included[day] = true;
        }
        // 1D array to store optimal solutions to subproblems
        int[] dp = new int[days[days.length - 1] + 1];
        dp[0] = 0;
        // loop invariant: optimal cost for dp[i-1] has been computed and stored.
        for (int j = 1; j < dp.length; j++) {
            // if no travel on day j, cost would be same as previous day
            if (!included[j]) {
                dp[j] = dp[j - 1];
                continue;
            }

            dp[j] = dp[j - 1] + costs[0];   // 1 day pass
            if (j - 7 >= 0) { // 7 day pass
                dp[j] = Math.min(dp[j], dp[j - 7] + costs[1]);
            } else {
                dp[j] = Math.min(dp[j], costs[1]);
            }
            if (j - 30 >= 0) {  // 30 day pass
                dp[j] = Math.min(dp[j], dp[j - 30] + costs[2]);
            } else {
                dp[j] = Math.min(dp[j], costs[2]);
            }
        }
        return dp[days[days.length - 1]];
    }
}