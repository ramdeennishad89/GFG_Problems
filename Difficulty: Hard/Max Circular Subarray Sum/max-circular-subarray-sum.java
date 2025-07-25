class Solution {
    public int maxCircularSum(int arr[]) {
        // code here
        int Omax = Integer.MIN_VALUE, Omin = Integer.MAX_VALUE;
        int currMax = 0, currMin = 0, total = 0;
        
        for(int i=0; i<arr.length; i++) {
            total += arr[i];
            
            currMin = Math.min(arr[i], currMin + arr[i]);
            Omin = Math.min(currMin, Omin);
            
            currMax = Math.max(arr[i], currMax + arr[i]);
            Omax = Math.max(currMax, Omax);
        }
        
        if(Omax < 0) return Omax;
        
        return Math.max(Omax, total - Omin);
    }
}
