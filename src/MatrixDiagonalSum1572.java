class Solution {
    public int diagonalSum(int[][] mat) {

        int sum = 0;
        int l = mat.length;

        for(int i=0;i<l;i++){
            sum += mat[i][i]; //Primary diagonal
            sum += mat[i][l-1-i]; //Secondary diagonal
        }

//if the length is odd we subtract the middle element(element that is in both primary and secondary diagonal)
        return (l % 2 == 0) ? sum :sum - mat[l/2][l/2];
    }
}
