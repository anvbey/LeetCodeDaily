class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = n-1;

        while(l <= r)
        {
            int mid = l + (r-l)/2;

            if(matrix[mid][0] <= target && target <= matrix[mid][m-1])
            {
                int left = 0, right = m-1;

                while(left <= right)
                {
                    int middle = left + (right - left)/2;

                    if(matrix[mid][middle] == target)
                        return true;
                    else if(matrix[mid][middle] > target)
                    {
                        right = middle -1;
                    }
                    else
                        left = middle + 1;
                }

                break;
            }
            else if(matrix[mid][0] < target)
            {
                l = mid + 1;
            }
            else
            {
                r = mid- 1;
            }
        }

        return false;














        // for(int i=0;i<matrix.length;i++)
        // {
        //     if(target <= matrix[i][matrix[i].length-1])
        //     {
        //         int l = 0, r= matrix[i].length-1;

        //         while(l <= r)
        //         {
        //             int mid = l + (r - l)/2;

        //             if(matrix[i][mid] == target)
        //                 return true;
        //             else if(matrix[i][mid] < target)
        //                 l = mid+1;
        //             else
        //                 r = mid -1;
        //         }
        //     }
        // }


        // return false;
    }
}
