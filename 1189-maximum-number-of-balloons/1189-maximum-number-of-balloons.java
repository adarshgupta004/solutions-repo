class Solution {
    public int maxNumberOfBalloons(String text) {
     HashMap<Character, Integer> map = new HashMap<>();

     map.put('b' , 0);
     map.put('a' , 0);
     map.put('l' , 0);
     map.put('o' , 0);
     map.put('n' , 0);

     for(char ch : text.toCharArray()){
        if(map.containsKey(ch)){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
     }   

     int minValue = Integer.MAX_VALUE;

     for(Map.Entry<Character, Integer> entry : map.entrySet()){
        char key = entry.getKey();
        int value = entry.getValue();

        if(key == 'l' || key == 'o'){
            value = value / 2;
        }
        minValue = Math.min(minValue, value);
     }
     return minValue;
    }
}