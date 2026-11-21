class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
      int newLogs[] = new int[n + 1];
      for(int i = 0; i < bookings.length; i++){
        newLogs[bookings[i][0] - 1] += bookings[i][2];
        newLogs[bookings[i][1]] -= bookings[i][2];
      }  
      int seat = 0;

      for(int i = 0; i < newLogs.length; i++){
        seat += newLogs[i];
        newLogs[i] = seat;
      }
      return Arrays.copyOf(newLogs, n);
    }
}