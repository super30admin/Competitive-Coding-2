class Solution {
public:
    string minWindow(string s, string t) {
        //create a freq map for the T
        unordered_map<char,int>t_track;
        //base case
        if(t.size() > s.size())
            return "";
        for(char c : t)
        {
            t_track[c]++;
        }

        // now intialize two pointers
        int count = t.size();
        int start = 0;
        int end = 0;
        int minLength = INT_MAX;
        int minStart = 0;

        
        while(end < s.length())
        {
            //check if the tracker is empty
            if(t_track[s[end]] > 0 )
            {
                //if it is greater than 0 means char is present in thet
                count--;
            }
            //we decrement the count for each char
            t_track[s[end]]--;
            end++;
            //once we find all the char
            while(count == 0)
            {
                
                if(end-start < minLength)
                {
                    //update the min len
                    minLength = end -start;
                    minStart = start;
                } 
                t_track[s[start]]++;
                if(t_track[s[start]] > 0)
                    count++;

                start++;
            }
        }
        return minLength == INT_MAX ? "" : s.substr(minStart , minLength);
    }
};
//Time complxity would O(2N) where each char is visited by start and end
//space complxity O(1) - cause O(26)