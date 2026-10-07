class Solution {
    public int maxPoints(int[][] points) {
      int n = points.length;
      if(n <= 2) return n;

      int maxPointsOnALine = 1;

      for(int i = 0; i < n; i++){
        Map<String,Integer> slopeMap = new HashMap<>();
        int localMax = 0;

        for(int j = i + 1; j < n; j++){
            int dx = points[j][0] - points[i][0];
            int dy = points[j][1] - points[i][1];

            int gcd = gcd(dx, dy);
            dx /= gcd;
            dy /= gcd;

            String slopeKey = dx + ":" + dy;

            slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
            localMax = Math.max(localMax, slopeMap.get(slopeKey));
        }

        maxPointsOnALine = Math.max(maxPointsOnALine, localMax + 1);
      }  
      return maxPointsOnALine;
    }

private int gcd(int a, int b){
    return b == 0 ? a : gcd(b, a%b);
}
}