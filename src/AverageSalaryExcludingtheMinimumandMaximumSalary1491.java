class Solution {
    public double average(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int s=0;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i] < min)
                min = arr[i];
            if(arr[i]> max)
                max = arr[i];
            s += arr[i];
        }

        s = s - min - max;
        return (double)s/(arr.length-2);
    }
}
