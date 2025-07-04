class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int i=0,j=0,n = arr.length,countK=0,totalCount = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        while(j<n)
        {
            if(map.containsKey(arr[j]))
            map.put(arr[j],map.get(arr[j])+1);
            else
            {
                countK++;
                map.put(arr[j],1);
            }
            
            if(countK<=k)
            {
                totalCount+=(j-i+1);
                j++;
            }
            else
            {
                while(countK>k)
                {
                    int I = arr[i];
                    int countI = map.get(I);
                    if(countI==1)
                    {
                        countK--;
                        map.remove(I);
                    }
                    else
                    map.put(I,countI-1);
                    i++;
                }
                totalCount+=j-i+1;
                j++;
            }
        }
        return totalCount;
    }
}
