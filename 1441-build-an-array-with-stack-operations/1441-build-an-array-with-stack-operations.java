class Solution {
    public List<String> buildArray(int[] target, int n) {
   List<String> operations = new ArrayList<>();
   int currentNum = 1;

   for(int num : target){
    while(currentNum < num){
        operations.add("Push");
        operations.add("Pop");
        currentNum++;
    }
    operations.add("Push");
    currentNum++;
   }     
   return operations;
    }
}