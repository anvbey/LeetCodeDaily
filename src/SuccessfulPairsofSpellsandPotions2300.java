class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long target) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            int ele = spells[i];
            int st = 0;
            int end = potions.length-1;
            int idx = -1;
            while(st <= end){
                int mid = (st+end)/2;
                if((long)potions[mid]*ele > target){
                    end = mid-1;
                }else if((long)potions[mid]*ele < target){
                    st = mid+1;
                }else{
                    idx = mid;
                    end = mid-1;
                }
            }
            if(idx == -1){
                idx = st;
            }
            ans[i] = potions.length-idx;
        }
        return ans;
    }
    
}
