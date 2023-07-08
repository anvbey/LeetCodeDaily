class Solution {
    public long putMarbles(int[] weights, int k) {
        if(weights.length == k) return 0;
        int[] pair = new int[weights.length - 1];
        for(int i=1;i<weights.length;i++){
            pair[i-1] = weights[i-1] + weights[i];
        }
        Arrays.sort(pair);
        long min=0L,max=0L;
        for(int i=0,j=pair.length-1;i<k-1;){
            min += pair[i++];
            max += pair[j--];
        }
        return max - min;
    }
}
