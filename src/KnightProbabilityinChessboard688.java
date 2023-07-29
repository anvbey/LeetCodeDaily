class Solution {
    double ans;
    public double knightProbability(int n, int k, int row, int column) {

        ans = 0.0;
        HashMap<String, Double> hm = new HashMap<>();
        double answer = helper(n, k, row, column, 1, hm);
        return answer;
    }

    public double helper(int n, int k, int i, int j, int x, HashMap<String, Double> hm)
    {
        if(k == 0)
        {
            ans += (1.0/(double)x); 
            System.out.println(1.0/x);
            // return (1.0/(double)x);
            return 1.0;
        }
        String key = i + "code" + j + "bix" + k;
        if(hm.containsKey(key))
        {
            return hm.get(key);
        }

        double answer = 0.0;
        int arr[][]= {{-2, -1}, {-1,-2}, {-2, 1}, {-1, 2}, {1,-2}, {2,-1}, {2,1}, {1, 2}};

        for(int a = 0;a<8;a++)
        {
            int row= i + arr[a][0];
            int col = j + arr[a][1];
            // if(k == 1)
               

            if(row>= 0 && row < n   &&  col >=0 && col<n)
            {
                answer += helper(n, k-1, row, col, x*8, hm)/8.0;
            }
        }

        hm.put(key, answer);

        return answer;
    }
}
