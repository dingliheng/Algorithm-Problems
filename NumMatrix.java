c class NumMatrix {
    int[][] original;
    int[][] tree;
    int m;
    int n;
    
    public NumMatrix(int[][] matrix) {
        //corner case
        if (matrix == null || matrix.length == 0) return;
        m = matrix.length;
        n = matrix[0].length;
        original = new int[m][n];
        tree = new int[m+1][n+1];
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if (m == 0 || n == 0) return;
        int delta = val - original[row][col];
        original[row][col] = val;
        for (int i=row+1; i <= m; i += i & (-i)) {
            for (int j=col+1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1);
    }
    
    public int sum(int row, int col) {
        int res = 0;
        for (int i=row; i>0; i -= i & (-i)) {
            for (int j=col; j>0; j -= j & (-j)) {
                res += tree[i][j];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
