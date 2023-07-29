class Solution {
    int arr[];
    int length;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashSet<String> hs = new HashSet<>();

        for(String i: req_skills)
        {
            hs.add(i);
        }
        List<Integer> ls = new ArrayList<>();
        int ans = helper(hs, people, 0, 0, ls);
        
        length = ans;
        arr = new int[ans];

        ans = helper1(hs, people, 0, 0, ls);
       
        return arr;
    }
    public int helper1(HashSet<String> hs, List<List<String>> people, int ind, int n, List<Integer> ls)
    {
        if(hs.size() == 0)
        {
            if(length == ls.size())
            {
                for(int i=0;i<length;i++)
                {
                    arr[i] = ls.get(i);
                }
            }
            return n;
        }

        if(ind == people.size())
        {
            return Integer.MAX_VALUE;
        }

        List<String> temp = new ArrayList<>();
        for(int i=0;i<people.get(ind).size();i++)
        {
            if(hs.contains(people.get(ind).get(i)))
            {
                temp.add(people.get(ind).get(i));
                hs.remove(people.get(ind).get(i));
            }
        }
        ls.add(ind);

        int take = helper1(hs, people, ind+1, n+1, ls);

        for(int i=0;i<temp.size();i++)
        {
            hs.add(temp.get(i));
        }
        int l = ls.size()-1;
        ls.remove(l);

        int notTake = helper1(hs, people, ind+1, n, ls);

        return Math.min(take, notTake);
    }

    public int helper(HashSet<String> hs, List<List<String>> people, int ind, int n, List<Integer> ls)
    {
        if(hs.size() == 0)
        {
            return n;
        }

        if(ind == people.size())
        {
            return Integer.MAX_VALUE;
        }

        List<String> temp = new ArrayList<>();
        for(int i=0;i<people.get(ind).size();i++)
        {
            if(hs.contains(people.get(ind).get(i)))
            {
                temp.add(people.get(ind).get(i));
                hs.remove(people.get(ind).get(i));
            }
        }
        ls.add(ind);

        int take = helper(hs, people, ind+1, n+1, ls);

        for(int i=0;i<temp.size();i++)
        {
            hs.add(temp.get(i));
        }
        int l = ls.size()-1;
        ls.remove(l);

        int notTake = helper(hs, people, ind+1, n, ls);

        return Math.min(take, notTake);
    }
}
