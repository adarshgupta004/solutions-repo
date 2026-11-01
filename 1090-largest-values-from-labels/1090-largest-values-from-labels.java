class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
     int n = values.length;
     int arr[][] = new int[n][2];
     int map[] = new int[20001];
     for(int i = 0; i < n; i++){
        arr[i][0] = values[i];
        arr[i][1] = labels[i];

        map[labels[i]]++;
     }   
     for(int i = 0; i < n; i++){
        map[labels[i]] = Math.min(map[labels[i]], useLimit);
     }
     Arrays.sort(arr,(a,b)->(a[0]-b[0]));
     int k = n;
     int sum = 0;
     while(--k >= 0 && numWanted > 0){
        int f = map[arr[k][1]];
        if(f > 0){
            sum += arr[k][0];
            map[arr[k][1]]--;
            numWanted--;
        }
     }
     return sum;
    }
}