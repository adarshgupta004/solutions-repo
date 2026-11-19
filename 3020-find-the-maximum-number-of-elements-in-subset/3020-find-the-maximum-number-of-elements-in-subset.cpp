class Solution {
public:
    int maximumLength(vector<int>& n) {
    unordered_map<double,int> um;

    for(auto val: n){
        um[val]++;
    }    
    int cnt = 0;
    int ans = 1;

    for(auto val : um){
        double fnd = pow(val.first, .5);
        cnt = 1;

        while(fnd >= 2){
            if(um.find(fnd) != um.end()){
                if(um[fnd] >= 2){
                    cnt += 2;
                }
                else{
                    break;
                }
                fnd = pow(fnd, .5);
            }
            else{
                break;
            }
        }
        ans = max(ans,cnt);
        cnt = 0;
    }
    int maxi = 0;
    if(um.find(1) != um.end()){
        maxi = um[1];
    }
    if(maxi > ans){
        if(maxi & 1){return maxi;}
        return maxi - 1;
    }
    return ans;
    }
};