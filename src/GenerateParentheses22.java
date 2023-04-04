class Solution {
    static List<String> ls;
    public List<String> generateParenthesis(int n) {
        ls = new ArrayList<>();
        solve(n, n,"");  // true == 0
        Collections.reverse(ls);
    
        return ls;
    }

    public static void solve(int n, int m, String w)
    {
      // just checking the length if fullfilled then just add the string to the list and fall back
      if(n == 0 && m == 0)
      {
          ls.add(w);
          return;
      }
      
      // if last value is 0 so we can have add either 1 OR 0
      // flag == true means last digit is 0
    
    if(n > 0)
        solve(n-1, m, w + "(");
    
    if(n < m && m > 0)
        solve(n, m-1, w + ")");
    
    
   
        
  }
}
