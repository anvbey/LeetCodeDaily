class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
       //make vector of pairs to store in order [nums2,nums1]
       int n = nums1.size();
       vector<pair<int,int>> v;
       for(int i=0;i<n;i++){
           v.push_back({nums2[i],nums1[i]});
       } 
       //then sort them we did [nums2,nums1] due to wanna sort the nums2
       sort(v.begin(),v.end());
       long long ans =0;
       long long currsum =0;
       //make priority queue of min due to remove the least choice in iteration and
       //to maintain kth size comparison
       priority_queue<int, vector<int>,greater<int>> pq;
       //for first iteration --we iterate reversvily
       for(int i=n-1;i>n-1-k;i--)//to get the first k size value 
       {
           pq.push(v[i].second);
           currsum += v[i].second;
       }
       //compare the first iteration ans
       //due to sorting of pairs we knew who is minimum in compare of kth indexes
       ans = max(ans,(currsum * v[n-k].first));
       //and then other iteration -- coz we get currsum all is just maintaing
       //the size of k
       for(int i=n-1-k;i>=0;i--){
           int val = pq.top();
           pq.pop(); //removing the least imp choice and also maintaing kth size
           currsum -= val;
           pq.push(v[i].second);
           currsum += v[i].second;
           ans = max(ans,(currsum * v[i].first));
       }
       return ans;
    }
};
