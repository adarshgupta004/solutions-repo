class Solution {
    public int minSwapsCouples(int[] row) {
     int swaps = 0;
     int n = row.length;
     int[] position = new int[n];

     for(int i = 0; i < n; i++){
        position[row[i]] = i;
     }   

     for(int i = 0; i < n; i += 2){
        int first = row[i];
        int second = row[i + 1];
        int expectedSecond = first ^ 1;

        if(second != expectedSecond){
            swaps++;
            int partnerIndex = position[expectedSecond];
            swap(row, i + 1, partnerIndex);

            position[second] = partnerIndex;
            position[expectedSecond] = i + 1;
        }
     }
     return swaps;
    }
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}