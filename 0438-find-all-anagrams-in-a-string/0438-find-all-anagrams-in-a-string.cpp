class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
      vector<int> res;

      int m = s.size();
      int n = p.size();

      if(n > m)
      return res;

      vector<int> freq1(26, 0);
      vector<int> freq2(26,0);

      for(int i = 0; i < n; i++){
        freq1[s[i] - 'a']++;
        freq2[p[i] - 'a']++;
      }  

      if(freq1 == freq2)
      res.push_back(0);

      for(int i = n; i < m; i++){
        freq1[s[i] - 'a']++;
        freq1[s[i - n] - 'a']--;

        if(freq1 == freq2)
        res.push_back(i - n + 1);
      }
      return res;
    }
};