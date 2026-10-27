class Solution {
public:
    vector<int> shortestToChar(string s, char c) {
    priority_queue<int, vector<int>, greater<int>> pq;
    vector<int> ans;
    int prev = -1;
    int n = s.size();

    for(int i = 0; i < n; i++){
        if(c == s[i])
        pq.push(i);
    }    
    for(int i = 0; i < n; i++){
       if(i == pq.top()) {
        prev = pq.top();
        pq.pop();
       }

       if (prev == -1){
        ans.push_back(abs(pq.top() - i));
       }
       else if(pq.empty()) {
        ans.push_back(abs(prev - i));
       }
       else{
        ans.push_back(min(abs(prev - i), abs(pq.top() - i)));
       }
    }
    return ans;
    }
};