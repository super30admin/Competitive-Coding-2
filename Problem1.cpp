// T : O(N)/
//S : O(N)

class Solution {
public:
    int longestPalindrome(string s) {
        unordered_set<char> store;
        int cnt = 0;
        for(auto i: s){
            if(store.find(i)!=store.end()){
                cnt += 2;
                store.erase(i);
            }else{
            store.insert(i);
            }
        }
        if(store.size()>0){
            return cnt+1;
        }
        return cnt;
        }
};