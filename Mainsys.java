class Main
{
    // 
    public static int findMaxSumSubmatrix(int matrix[][])
    {
        // M x N matrix
        final int M = matrix.length;
        final int N = matrix[0].length;
 
        // S[i][j] stores sum of sub-matrix formed by row 0 to i-1
        // and column 0 to j-1
        int[][] S = new int[M+1][N+1];
 
        // pre-process the matrix to fill S[][]
        for (int i = 0; i <= M; i++)
        {
            for (int j = 0; j <= N; j++)
            {
                if (i == 0 || j == 0) {
                    S[i][j] = 0;
                } else {
                    S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] +
                                      matrix[i-1][j-1];
                }
            }
        }
 
        int maxSum = Integer.MIN_VALUE;
        int rowStart = 0, rowEnd = 0, colStart = 0, colEnd = 0;
 
        for (int i = 0; i < M; i++)
        {
            for (int j = i; j < M; j++)
            {
                for (int m = 0; m < N; m++)
                {
                    for (int n = m; n < N; n++)
                    {
                       
                        int submatrix_sum = S[j+1][n+1] - S[j+1][m]
                                            - S[i][n+1] + S[i][m];
 
                        //
                        if (submatrix_sum > maxSum)
                        {
                            maxSum = submatrix_sum;
                            rowStart = i;
                            rowEnd = j;
                            colStart = m;
                            colEnd = n;
                        }
                    }
                }
            }
        }
 
        System.out.println("Sub-matrix is formed by row "
                            + rowStart + " to " + rowEnd +
                            " and column from "
                            + colStart + " to " +  colEnd);
 
        return maxSum;
    }
 
    public static void main(String[] args)
    {
        // input matrix
        int matrix[][] =
        {
            { -5, -6,  3,  1,  0 },
            {  9,  7,  8,  3,  7 },
            { -6, -2, -1,  2, -4 },
            { -7,  5,  5,  2, -6 },
            {  3,  2,  9, -5,  1 }
        };
 
        // 
        System.out.print("The maximum sum of sub-matrix is " +
                                 findMaxSumSubmatrix(matrix));
    }
}
