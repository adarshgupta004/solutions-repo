class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> smap = new HashMap<>();
        HashMap<Character,Character> tmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(smap.containsKey(cs) && smap.get(cs)!=ct || tmap.containsKey(ct) && tmap.get(ct) != cs){
                return false;
            }
            smap.put(cs,ct);
            tmap.put(ct,cs);
        }
        return true;
    }
}