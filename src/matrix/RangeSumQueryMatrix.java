package matrix;


// 304. Range Sum Query 2D - Immutable
class NumMatrix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        fillSumMatrix(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row2+1][col1] - sumMatrix[row1][col2+1] + sumMatrix[row1][col1];
    }

    private void fillSumMatrix(int[][] matrix) {
        int row = matrix.length + 1;
        int col = matrix[0].length + 1;
        sumMatrix = new int[row][col];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
}

